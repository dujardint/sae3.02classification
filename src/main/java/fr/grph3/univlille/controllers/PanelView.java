package fr.grph3.univlille.controllers;

import java.io.File;
import java.net.URL;
import java.util.*;

import fr.grph3.univlille.AbstractView;
import fr.grph3.univlille.MVCModelManager;
import fr.grph3.univlille.models.columns.INormalizableColumn;
import fr.grph3.univlille.models.points.DataType;
import fr.grph3.univlille.models.points.IPoint;
import fr.grph3.univlille.models.points.Iris;
import fr.grph3.univlille.models.points.Titanic;
import fr.grph3.univlille.utils.CSVModel;
import fr.grph3.univlille.utils.KnnMethod;
import fr.grph3.univlille.utils.MVCModel;
import fr.grph3.univlille.utils.distances.EuclidDistance;
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
    private TextField robustness;

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
    private CheckBox classifyCheckBox;

    @FXML
    private ComboBox<String> classifiedByComboBox;

    @FXML
    private Slider knnSlider;

    @FXML
    private Label pointDisplay;

    private XYChart.Series<Number, Number> series;

    private List<XYChart.Series<Number, Number>> allSeries;

    private MVCModel model;

    private MVCModelManager modelManager;

    private KnnMethod knnMethod;

    public PanelView(Stage stage) {
        super(stage);
        this.modelManager = new MVCModelManager();
        this.knnMethod = new KnnMethod();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        knnSlider.valueProperty().addListener((obs, oldval, newVal) -> knnSlider.setValue(Math.round(newVal.doubleValue())));
        initDefaultData();
        csvPicker.getSelectionModel().select(modelManager.names().get(0));
        csvPicker.setItems(FXCollections.observableArrayList(modelManager.names()));
        robustness.setText(String.valueOf(knnMethod.getRobustesse(new EuclidDistance(model.getColumns()), model.getPoints(), knnSlider.getValue())));
        update();
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
        this.model = modelManager.switchModel(title);
        xColumnPicker.setItems(FXCollections.observableList(model.getNormalizableColumns()));
        yColumnPicker.setItems(FXCollections.observableList(model.getNormalizableColumns()));
        initDefaultValue(xColumnPicker.getSelectionModel(), model.defaultXCol());
        initDefaultValue(yColumnPicker.getSelectionModel(), model.defaultYCol());
        drawPoints();
    }

    @FXML
    public void onXCategorySelected() {
        drawPoints();
    }

    @FXML
    public void onYCategorySelected() {
        drawPoints();
    }

    /*
     * ACTUELLEMENT SA DEMANDE DE SAISIR UN POINT X ET Y ET CA L'AJOUTE
     * J'ai rajouté pour saisir un iris et un titanic en demandant ses caracteristiques mais j'ai mis en commentaire car c'est pas fini
     * Un objet iris ou titanic est crée, il reste a avoir sa normallisation et a l'ajouter au graphique
     */

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

    @FXML
    public void onClassify() {
        drawPoints();
    }

    @FXML
    public void onKnn() {
        System.out.println(knnSlider.getValue());
        robustness.setText(String.valueOf(knnMethod.getRobustesse(new EuclidDistance(model.getColumns()), model.getPoints(), knnSlider.getValue())));
    }

    public void update() {
        xColumnPicker.setItems(FXCollections.observableList(model.getNormalizableColumns()));
        yColumnPicker.setItems(FXCollections.observableList(model.getNormalizableColumns()));
        initDefaultValue(xColumnPicker.getSelectionModel(), model.defaultXCol());
        initDefaultValue(yColumnPicker.getSelectionModel(), model.defaultYCol());
        drawPoints();
    }

    private void drawPoints() {

        List<IPoint> points = model.getPoints();

        INormalizableColumn xColumn = xColumnPicker.getSelectionModel().getSelectedItem();
        INormalizableColumn yColumn = yColumnPicker.getSelectionModel().getSelectedItem();

        if (!classifyCheckBox.isSelected()) {
            XYChart.Series<Number, Number> xy = new XYChart.Series<>();
            xy.setName(model.getTitle());
            for (IPoint p : points) {
                XYChart.Data<Number, Number> data = new XYChart.Data<>(xColumn.getNormalizedValue(p.getValue(xColumn)), yColumn.getNormalizedValue(p.getValue(yColumn)));
                data.nodeProperty().addListener((observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        Tooltip.install(data.getNode(), new Tooltip(p.toString()));
                    }
                });
                xy.getData().add(data);
            }
            chart.getData().setAll(xy);
            return;
        }

        List<XYChart.Series<Number, Number>> series = new ArrayList<>();

        Map<String, List<IPoint>> links = new HashMap<>();
        for (IPoint point : points) {
            String category = point.getCategory();
            if (!links.containsKey(category)) links.put(category, new ArrayList<>());
            links.get(point.getCategory()).add(point);
        }
        List<String> categories = new ArrayList<>(links.keySet());
        categories.forEach(category -> {
            XYChart.Series<Number, Number> xy = new XYChart.Series<>();
            xy.setName(category);
            links.get(category).forEach(p -> {
                xy.getData().add(new XYChart.Data<>(xColumn.getNormalizedValue(p.getValue(xColumn)), yColumn.getNormalizedValue(p.getValue(yColumn))));
            });
            series.add(xy);
        });

        chart.setData(FXCollections.observableList(series));
    }

    private void displayPointData(List<IPoint> points) {
        pointDisplay.setText(points.toString());
    }

    public void addPoint(double xVal, double yVal) {
        series.getData().add(new XYChart.Data<>(xVal, yVal));
    }
    
    

    public MVCModel getModel() {
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
    public Parent loadView() {
        return loadView("src/main/resources/views/Panel.fxml");
    }
}
