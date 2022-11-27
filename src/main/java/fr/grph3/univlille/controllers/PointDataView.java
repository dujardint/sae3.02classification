package fr.grph3.univlille.controllers;

import fr.grph3.univlille.AbstractView;
import fr.grph3.univlille.models.points.IPoint;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author Exalow on 26/11/2022 at 19:10
 */

public class PointDataView extends AbstractView {

    private List<IPoint> point;

    public PointDataView(Stage stage, List<IPoint> point) {
        super(stage);
        this.point = point;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(point.toString());
    }

    @Override
    public Parent loadView() {
        return loadView("src/main/resources/views/PointData.fxml");
    }
}
