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
import fr.grph3.univlille.utils.distances.EuclidDistance;
import fr.grph3.univlille.utils.distances.IDistance;
import fr.grph3.univlille.utils.distances.ManhattanDistance;
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
    private ComboBox<String> csvPicker;

    @FXML
    private TextField robustness;

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

    @FXML
    private ComboBox<String> distancesComboBox;

    @FXML
    private Spinner<Integer> knnSpinner;

    private double lastKnnValue;

    private List<XYChart.Series<Number, Number>> allSeries;

    private AbstractMVCModel model;

    private MVCModelManager modelManager;

    private KnnMethod knnMethod;

    private ICategory selectedCategory;

    public PanelView(Stage stage) {
        super(stage);
        this.modelManager = new MVCModelManager();
        this.knnMethod = new KnnMethod();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.selectedCategory = new Category("ALL");
        knnSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 3, 1));
        initDefaultData();
        csvPicker.getSelectionModel().select(modelManager.names().get(0));
        csvPicker.setItems(FXCollections.observableArrayList(modelManager.names()));
        distancesComboBox.setItems(FXCollections.observableList(Arrays.asList("Euclid", "Manhattan")));
        initDefaultValue(distancesComboBox.getSelectionModel(), "Euclid");
        onKnn();
        onDataTypeSelected();
    }

    private void initDefaultData() {
        CSVModel irisCSVModel = new CSVModel(Iris.class, "Default Iris");
        CSVModel titanicCSVModel = new CSVModel(Titanic.class, "Default Titanic");
        modelManager.subscribe(irisCSVModel, "src/main/resources/iris.csv");
        modelManager.subscribe(titanicCSVModel, "src/main/resources/titanic.csv");
        this.model = modelManager.switchModel("Default Iris");
    }

    @FXML
    public void onOpen() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select data csv");
        File selectedCsv = fileChooser.showOpenDialog(stage);
        DataType type = extractDataType(selectedCsv);
        if (type == null) return;
        model.loadFromFile(selectedCsv.getPath());
        stage.setTitle(selectedCsv.getName());
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
	public void onAddPoint() {
		Stage adpStag = new Stage();
		if(csvPicker.getSelectionModel().getSelectedItem().contains("Iris")) { //PAS ENCORE FONCTIONEL
			AddPointIrisView addPointView = new AddPointIrisView(adpStag, this); //la nouvelle vue
			adpStag.setScene(new Scene(addPointView.loadView()));
			adpStag.show();
		}

		else if(csvPicker.getSelectionModel().getSelectedItem().contains("Titanic")) {
			AddPointTitanicView addPointView = new AddPointTitanicView(adpStag, this);
			adpStag.setScene(new Scene(addPointView.loadView()));
			adpStag.show();
		}

		else {
			AddPointView addPointView = new AddPointView(adpStag, this);
			adpStag.setScene(new Scene(addPointView.loadView()));
			adpStag.show();
		}
	}
    
    public int getKnnSpinnerValueInt() {
    	return knnSpinner.getValue();
    }

    @FXML
    public void onDataTypeSelected() {
        String title = csvPicker.getSelectionModel().getSelectedItem();
        this.model = modelManager.switchModel(title);
        xColumnPicker.setItems(FXCollections.observableList(model.getNormalizableColumns()));
        yColumnPicker.setItems(FXCollections.observableList(model.getNormalizableColumns()));
        initDefaultValue(xColumnPicker.getSelectionModel(), model.defaultXCol());
        initDefaultValue(yColumnPicker.getSelectionModel(), model.defaultYCol());
        classifiedByComboBox.setItems(FXCollections.observableList(model.getCategories()));
        classifiedByComboBox.getItems().add(new Category("ALL"));
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
    public void onKnn() {
        String selected = distancesComboBox.getSelectionModel()
                .getSelectedItem();
        IDistance distance = selected.equals("Euclid") ? new EuclidDistance(model.getColumns()) : new ManhattanDistance(model.getColumns());
        robustness.setText(String.valueOf(knnMethod.getRobustesse(distance, model.getPoints(), knnSpinner.getValue())));
    }

    @FXML
    public void onDistanceSelected() {
        onKnn();
    }

    @FXML
    public void onCategorySelected() {
        this.selectedCategory = classifiedByComboBox.getSelectionModel()
                .getSelectedItem();
        drawPointsCloud();
    }

    public void drawPointsCloud() {
        clearCloud();
        if (!"ALL".equals(selectedCategory.getTitle())) {
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

        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName(category.getTitle());

        System.out.println(xColumn);
        System.out.println(yColumn);
        System.out.println(category.getTitle());
        System.out.println(category.getPoints().toString());

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

    public AbstractMVCModel getModel() {
        return model;
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
