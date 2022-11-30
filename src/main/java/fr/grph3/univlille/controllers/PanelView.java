package fr.grph3.univlille.controllers;

import java.io.File;
import java.net.URL;
import java.util.*;

import fr.grph3.univlille.AbstractView;
import fr.grph3.univlille.MVCModelManager;
import fr.grph3.univlille.models.categories.Category;
import fr.grph3.univlille.models.categories.ICategory;
import fr.grph3.univlille.models.columns.INormalizableColumn;
import fr.grph3.univlille.models.points.DataType;
import fr.grph3.univlille.models.points.IPoint;
import fr.grph3.univlille.models.points.Iris;
import fr.grph3.univlille.models.points.Titanic;
import fr.grph3.univlille.utils.*;
import fr.grph3.univlille.utils.Observer;
import fr.grph3.univlille.utils.parsers.IIrisParser;
import fr.grph3.univlille.utils.parsers.ITitanicParser;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class PanelView extends AbstractView implements Observer {

    @FXML
    private BorderPane root;

    @FXML
    private ComboBox<AbstractMVCModel> csvPicker;

    @FXML
    private ScatterChart<Number, Number> chart;

    @FXML
    private ComboBox<INormalizableColumn> xColumnPicker;

    @FXML
    private ComboBox<INormalizableColumn> yColumnPicker;

    @FXML
    private CheckBox classifyCheckBox;

    @FXML
    private ComboBox<ICategory> classifiedByComboBox;

    private List<XYChart.Series<Number, Number>> allSeries;

    private AbstractMVCModel model;

    private MVCModelManager modelManager;

    private ICategory selectedCategory;

    public PanelView(Stage stage) {
        super(stage);
        this.modelManager = new MVCModelManager();}

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.selectedCategory = new Category("ALL");
        initDefaultData();
        csvPicker.getSelectionModel().select(modelManager.getModels().get(0));
        csvPicker.setItems(FXCollections.observableArrayList(modelManager.getModels()));
        onDataTypeSelected();
    }

    private void initDefaultData() {
        CSVModel irisCSVModel = new CSVModel(Iris.class, "Default Iris", new IIrisParser());
        irisCSVModel.attach(this);
        CSVModel titanicCSVModel = new CSVModel(Titanic.class, "Default Titanic", new ITitanicParser());
        titanicCSVModel.attach(this);
        modelManager.subscribe(irisCSVModel, "src/main/resources/iris.csv");
        modelManager.subscribe(titanicCSVModel, "src/main/resources/titanic.csv");
        this.model = modelManager.switchModel("Default Iris");
    }

    @FXML
    public void onOpen() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select CSV File to import");
        File selectedCsv = fileChooser.showOpenDialog(stage);
        DataType type = extractDataType(selectedCsv);
        if (type == null) return;
        AbstractMVCModel loadedModel = type.getModel();
        loadedModel.attach(this);
        modelManager.subscribe(loadedModel, selectedCsv.getPath());
        csvPicker.setItems(FXCollections.observableArrayList(modelManager.getModels()));
    }

    @FXML
    public void onAbout() {
        Stage aboutStage = new Stage();
        AboutView aboutView = new AboutView(aboutStage);
        aboutStage.setScene(new Scene(aboutView.loadView()));
        aboutStage.show();
    }

    @FXML
    public void onClose() {
        System.exit(0);
    }
    
    @FXML
	public void onNewPoint() {
        Stage addPointStage = new Stage();
        addPointStage.initOwner(stage);
        addPointStage.setResizable(false);
        AddPointView addPointView = new AddPointView(addPointStage, model);
        addPointStage.setScene(new Scene(addPointView.loadView()));
        addPointStage.show();
	}

    @FXML
    public void onDataTypeSelected() {
        AbstractMVCModel selected = csvPicker.getSelectionModel().getSelectedItem();
        if (selected == null) return;
        this.model = modelManager.switchModel(selected.getTitle());
        xColumnPicker.setItems(FXCollections.observableList(model.getNormalizableColumns()));
        yColumnPicker.setItems(FXCollections.observableList(model.getNormalizableColumns()));
        initDefaultValue(xColumnPicker.getSelectionModel(), model.defaultXCol());
        initDefaultValue(yColumnPicker.getSelectionModel(), model.defaultYCol());
        classifiedByComboBox.setItems(FXCollections.observableList(model.getCategories()));
        ICategory categoryAll = new Category("ALL");
        classifiedByComboBox.getItems().add(categoryAll);
        initDefaultValue(classifiedByComboBox.getSelectionModel(), categoryAll);
        Collections.reverse(classifiedByComboBox.getItems());
        drawPointsCloud();
    }

    @FXML
    public void onXCategorySelected() {
        drawPointsCloud();
    }

    @FXML
    public void onYCategorySelected() {
        drawPointsCloud();
    }

    @FXML
    public void onClassify() {
        drawPointsCloud();
    }

    @FXML
    public void onCategorySelected() {
        this.selectedCategory = classifiedByComboBox.getSelectionModel()
                .getSelectedItem();
        drawPointsCloud();
    }

    public void drawPointsCloud() {
        clearCloud();
        if (selectedCategory != null && !"ALL".equals(selectedCategory.getTitle())) {
            drawPointsCloud(selectedCategory.getPoints(), selectedCategory);
            return;
        } else if (classifyCheckBox.isSelected()) {
            drawClassifiedPointsCloud();
            return;
        }
        drawPointsCloud(model.getPoints(), new Category("ALL"));
    }

    public void drawPointsCloud(List<IPoint> points, ICategory category) {

        INormalizableColumn xColumn = xColumnPicker.getSelectionModel().getSelectedItem();
        INormalizableColumn yColumn = yColumnPicker.getSelectionModel().getSelectedItem();

        if (xColumn == null || yColumn == null) return;

        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName(category.getTitle());

        for (IPoint point : points) {
            double normalizedX = xColumn.getNormalizedValue(point.getValue(xColumn));
            double normalizedY = yColumn.getNormalizedValue(point.getValue(yColumn));
            XYChart.Data<Number, Number> data = new XYChart.Data<>(normalizedX, normalizedY);
            data.nodeProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue != null) Tooltip.install(data.getNode(), new Tooltip(point.toString()));
            });
            series.getData().add(data);
        }

        chart.getData().add(series);
    }

    public void drawClassifiedPointsCloud() {
        model.getCategories().forEach(c -> {
            if (!"ALL".equals(c.getTitle())) {
                drawPointsCloud(c.getPoints(), c);
            }
        });
    }

    public void clearCloud() {
        chart.setData(FXCollections.observableArrayList()); // Pas .clear() pour reset les symboles
    }

    private <T> void initDefaultValue(SingleSelectionModel<T> model, T value) {
        model.select(value);
    }

    private DataType extractDataType(File file) {
        String name = file.getName()
                .split("\\.")[0]
                .toUpperCase();
        try {
            return DataType.valueOf(name);
        } catch (IllegalArgumentException e) {
            //e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Subject subject) {
        drawPointsCloud();
    }

    @Override
    public Parent loadView() {
        return loadView("src/main/resources/views/Panel.fxml");
    }
}
