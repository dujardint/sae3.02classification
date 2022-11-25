package fr.grph3.univlille;

import java.io.File;
import java.net.URL;
import java.util.*;

import fr.grph3.univlille.models.columns.INormalizableColumn;
import fr.grph3.univlille.models.points.DataType;
import fr.grph3.univlille.models.points.IPoint;
import fr.grph3.univlille.models.points.Iris;
import fr.grph3.univlille.utils.CSVModel;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class PanelView extends AbstractView {

    @FXML
    private Button adPoint;

    @FXML
    private Button bCategorisation;

    @FXML
    private ComboBox<DataType> csvPicker;

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

    private CSVModel<? extends IPoint> model;

    public PanelView(Stage stage) {
        super(stage);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.model = new CSVModel<>(Iris.class, "Iris");
        this.model.loadFromFile("src/main/resources/iris.csv");
        csvPicker.getSelectionModel().select(DataType.IRIS);
        csvPicker.setItems(FXCollections.observableArrayList(DataType.values()));
        update();
    }

    @FXML
    public void onOpen() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select data csv");
        File selectedCsv = fileChooser.showOpenDialog(stage);
        DataType type = extractDataType(selectedCsv);
        if (type == null) return;
        this.model = type.getModel();
        model.loadFromFile(selectedCsv.getPath());
        stage.setTitle(selectedCsv.getName());
        update();
    }

    @FXML
    public void onClose() {
        System.exit(0);
    }

    @FXML
    public void onXCategorySelected() {
        drawPoints(model.getPoints());
    }

    @FXML
    public void onYCategorySelected() {
        drawPoints(model.getPoints());
    }

    @FXML
    public void onAddPoint() {
        Stage adpStag = new Stage();
        AddPointView addPointView = new AddPointView(stage);
        adpStag.setScene(new Scene(addPointView.loadView()));
        adpStag.show();
    }

    public void update() {
        initDefaultValue(xColumnPicker.getSelectionModel(), model.defaultXCol());
        initDefaultValue(yColumnPicker.getSelectionModel(), model.defaultYCol());
        xColumnPicker.setItems(FXCollections.observableList(model.getNormalizableColumns()));
        yColumnPicker.setItems(FXCollections.observableList(model.getNormalizableColumns()));
        drawPoints(model.getPoints());
    }

    private void drawPoints(List<? extends IPoint> points) {
        chart.getData().setAll(generateSeries(points));
    }

    private List<XYChart.Series<Number, Number>> generateSeries(List<? extends IPoint> points) {

        INormalizableColumn xColumn = xColumnPicker.getSelectionModel().getSelectedItem();
        INormalizableColumn yColumn = yColumnPicker.getSelectionModel().getSelectedItem();

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
        return series;
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
