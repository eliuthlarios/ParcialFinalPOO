package org.example.parcialfinalpoo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.example.parcialfinalpoo.SceneManager;

public class GenerarReportesController {
    @FXML
    private Button btnReporteA;
    @FXML
    private Button btnReporteB;
    @FXML
    private Button btnReporteC;
    @FXML
    private Button btnReporteD;
    @FXML
    private Button btnSalir5;

    @FXML
    public void btnReporteAOnAction(ActionEvent event) {
        ((Stage)btnReporteA.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/operacion-exitosa.fxml");
    }

    @FXML
    public void btnReporteBOnAction(ActionEvent event) {
        ((Stage)btnReporteA.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/operacion-exitosa.fxml");
    }

    @FXML
    public void btnReporteCOnAction(ActionEvent event) {
        ((Stage)btnReporteA.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/operacion-exitosa.fxml");
    }

    @FXML
    public void btnReporteDOnAction(ActionEvent event) {
        ((Stage)btnReporteA.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/operacion-exitosa.fxml");
    }

    @FXML
    public void btnSalir5OnAction(ActionEvent event) {
        ((Stage)btnReporteA.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/menu-empleado.fxml");
    }
}
