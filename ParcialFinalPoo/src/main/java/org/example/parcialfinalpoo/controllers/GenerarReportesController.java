package org.example.parcialfinalpoo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.example.parcialfinalpoo.SceneManager;

public class GenerarReportesController { //00103923 Declara la clase GenerarReportesController
    @FXML
    private Button btnReporteA; //00103923 Declara el boton btnReporteA
    @FXML
    private Button btnReporteB; //00103923 Declara el boton btnReporteB
    @FXML
    private Button btnReporteC; //00103923 Declara el boton btnReporteC
    @FXML
    private Button btnReporteD; //00103923 Declara el boton btnReporteD
    @FXML
    private Button btnSalir5; //00103923 Declara el boton btnSalir5

    @FXML
    public void btnReporteAOnAction(ActionEvent event) { //00103923 Declara el metodo void btnReporteAOnAction que recibe de parametros un event
        ((Stage)btnReporteA.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/reporte-A.fxml"); //00029223 nueva direccion del fxml del reporte A
    }

    @FXML
    public void btnReporteBOnAction(ActionEvent event) { //00103923 Declara el metodo void btnReporteBOnAction que recibe de parametros un event
        ((Stage)btnReporteA.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/reporte-B.fxml"); //00029223 nueva direccion del fxml del reporte B
    }

    @FXML
    public void btnReporteCOnAction(ActionEvent event) { //00103923 Declara el metodo void btnReporteCOnAction que recibe de parametros un event
        ((Stage)btnReporteA.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/reporte-C.fxml"); //00029223 nueva direccion del fxml del reporte C
    }

    @FXML
    public void btnReporteDOnAction(ActionEvent event) { //00103923 Declara el metodo void btnReporteDOnAction que recibe de parametros un event
        ((Stage)btnReporteA.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/reporte-D.fxml"); //00029223 nueva direccion del fxml del reporte D
    }

    @FXML
    public void btnSalir5OnAction(ActionEvent event) { //00103923 Declara el metodo void btnSalir5OnAction que recibe de parametros un event
        ((Stage)btnReporteA.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/menu-empleado.fxml"); //00103923 Cambia la escena usando SceneManager
    }
}
