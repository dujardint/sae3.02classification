package fr.grph3.univlille.controllers;

import java.io.File;
import java.net.URL;
import java.util.*;

import fr.grph3.univlille.AbstractView;
import fr.grph3.univlille.MVCModelManager;
import fr.grph3.univlille.models.IDataSet;
import fr.grph3.univlille.models.columns.INormalizableColumn;
import fr.grph3.univlille.models.points.DataType;
import fr.grph3.univlille.models.points.IPoint;
import fr.grph3.univlille.models.points.Iris;
import fr.grph3.univlille.models.points.Titanic;
import fr.grph3.univlille.utils.CSVModel;
import fr.grph3.univlille.utils.MVCModel;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class PanelView extends AbstractView {

    @FXML
    private BorderPane root;

    @FXML
    private Button adPoint;

    @FXML
    private Button bCategorisation;

    @FXML
    private ComboBox<String> csvPicker;

    @FXML
    private TextField knn;

    @FXML
    private TextField robustesse;

    @FXML
    private ScatterChart<Number, Number> chart;

    @FXML
    private NumberAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    @FXML
    private ComboBox<INormalizableColumn> xColumnPicker;

    @FXML
    private ComboBox<INormalizableColumn> yColumnPicker;

    @FXML
    private Label pointDisplay;

    private XYChart.Series<Number, Number> series;

    private List<XYChart.Series<Number, Number>> allSeries;

    private MVCModelManager modelManager;

    private MVCModel<? extends IPoint> model;

    public PanelView(Stage stage) {
        super(stage);
        stage.setTitle("Classificator");
        this.modelManager = new MVCModelManager();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CSVModel<Iris> irisCSVModel = new CSVModel<>(Iris.class, "Iris");
        CSVModel<Titanic> titanicCSVModel = new CSVModel<>(Titanic.class, "Titanic");
        irisCSVModel.loadFromFile("src/main/resources/iris.csv");
        titanicCSVModel.loadFromFile("src/main/resources/titanic.csv");
        modelManager.subscribe("Iris", irisCSVModel);
        modelManager.subscribe("Titanic", titanicCSVModel);
        List<String> titles = modelManager.getModels()
                .stream()
                .map(IDataSet::getTitle).toList();
        csvPicker.getSelectionModel().select(titles.get(0));
        csvPicker.setItems(FXCollections.observableArrayList(titles));
        modelManager.switchModel("Iris");
        this.model = modelManager.getCurrentModel();
        update();
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
        update();
        drawPoints();
    }

    @FXML
    public void onClose() {
        System.exit(0);
    }

    @FXML
    public void onDataTypeSelected() {
        String title = csvPicker.getSelectionModel().getSelectedItem();
        modelManager.switchModel(title);
        this.model = modelManager.getCurrentModel();
        this.update();
    }

    @FXML
    public void onXCategorySelected() {
        drawPoints();
    }

    @FXML
    public void onYCategorySelected() {
        drawPoints();
    }

    @FXML
    public void onAddPoint() {
        Stage adpStag = new Stage();
        if(csvPicker.getSelectionModel().getSelectedItem().equals("ZZIris")) { //PAS ENCORE FONCTIONEL
        	AddPointIrisView addPointView = new AddPointIrisView(adpStag, this); //la nouvelle vue
            adpStag.setScene(new Scene(addPointView.loadView()));
            adpStag.show();
        }
        
        else if(csvPicker.getSelectionModel().getSelectedItem().equals("ZZTitanic")) {
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

    public void update() {
        xColumnPicker.setItems(FXCollections.observableList(model.getNormalizableColumns()));
        yColumnPicker.setItems(FXCollections.observableList(model.getNormalizableColumns()));
        initDefaultValue(xColumnPicker.getSelectionModel(), model.defaultXCol());
        initDefaultValue(yColumnPicker.getSelectionModel(), model.defaultYCol());
        drawPoints();
    }

    private void drawPoints() {

        INormalizableColumn xColumn = xColumnPicker.getSelectionModel().getSelectedItem();
        INormalizableColumn yColumn = yColumnPicker.getSelectionModel().getSelectedItem();

        if (xColumn == null || yColumn == null) return;

        Iterator<Object> xColumnIterator = xColumn.iterator();
        Iterator<Object> yColumnIterator = yColumn.iterator();

        XYChart.Series<Number, Number> s = new XYChart.Series<>();
        s.setName(model.getTitle());

        while (xColumnIterator.hasNext() && yColumnIterator.hasNext()) {
            XYChart.Data<Number, Number> data = new XYChart.Data<>(xColumn.getNormalizedValue(xColumnIterator.next()), yColumn.getNormalizedValue(yColumnIterator.next()));
            data.nodeProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue != null) newValue.setOnMouseEntered(e -> displayPointData(model.getPointsFromColumns(data.getXValue(), data.getYValue(), xColumn, yColumn)));
            });
            s.getData().add(data);
        }
        this.series = s;
        chart.getData().setAll(series);
    }

    private void displayPointData(List<IPoint> points) {
        /*PointDataView dataView = new PointDataView(stage, points);
        Stage dataViewStage = new Stage();
        dataViewStage.setScene(new Scene(dataView.loadView()));
        dataViewStage.show();*/
        pointDisplay.setText(points.toString());
    }

    public void addPoint(double xVal, double yVal) {
        series.getData().add(new XYChart.Data<>(xVal, yVal));
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
    public Parent loadView() {
        return loadView("src/main/resources/views/Panel.fxml");
    }
}
