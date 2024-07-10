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
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/reporte-A.fxml"); //00029223 nueva direccion del fxml del reporte A
    }

    @FXML
    public void btnReporteBOnAction(ActionEvent event) {
        ((Stage)btnReporteA.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/reporte-B.fxml"); //00029223 nueva direccion del fxml del reporte B
    }

    @FXML
    public void btnReporteCOnAction(ActionEvent event) {
        ((Stage)btnReporteA.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/reporte-C.fxml"); //00029223 nueva direccion del fxml del reporte C
    }

    @FXML
    public void btnReporteDOnAction(ActionEvent event) {
        ((Stage)btnReporteA.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/reporte-D.fxml"); //00029223 nueva direccion del fxml del reporte D
    }

    @FXML
    public void btnSalir5OnAction(ActionEvent event) {
        ((Stage)btnReporteA.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/menu-empleado.fxml");
    }
}
