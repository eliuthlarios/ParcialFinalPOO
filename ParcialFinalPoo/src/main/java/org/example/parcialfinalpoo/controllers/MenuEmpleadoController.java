package org.example.parcialfinalpoo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.example.parcialfinalpoo.SceneManager;

public class MenuEmpleadoController { //00103923 Declara la clase MenuEmpleadoController
    @FXML
    private Button btnSalir3; //00103923 Declara el boton btnSalir3
    @FXML
    private Button btnModificarClientes; //00103923 Declara el boton btnModificarClientes
    @FXML
    private Button btnReportes; //00103923 Declara el boton btnReportes

    @FXML
    public void btnSalir3OnAction(ActionEvent event) { //00103923 Declara el metodo void btnSalir3OnAction que recibe de parametros un event
        ((Stage)btnSalir3.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/login.fxml"); //00103923 Cambia la escena usando SceneManager
    }

    @FXML
    public void btnModificarClientesOnAction(ActionEvent event) { //00103923 Declara el metodo void btnModificarClientesOnAction que recibe de parametros un event
        ((Stage)btnSalir3.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event,"/org/example/parcialfinalpoo/modificar-cliente.fxml"); //00103923 Cambia la escena usando SceneManager
    }

    @FXML
    public void btnReportesOnAction(ActionEvent event) { //00103923 Declara el metodo void btnReportesOnAction que recibe de parametros un event
        ((Stage)btnSalir3.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/generar-reportes.fxml"); //00103923 Cambia la escena usando SceneManager
    }
}
