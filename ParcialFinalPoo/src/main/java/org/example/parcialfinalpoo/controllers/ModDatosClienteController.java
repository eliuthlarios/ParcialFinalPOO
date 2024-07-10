package org.example.parcialfinalpoo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.example.parcialfinalpoo.SceneManager;

public class ModDatosClienteController { //00103923 Declara la clase ModDatosClienteController
    @FXML
    private Button btnDatosClientes; //00103923 Declara el boton btnDatosClientes
    @FXML
    private Button btnTarjetasClientes; //00103923 Declara el boton btnTarjetasClientes
    @FXML
    private Button btnSalir7; //00103923 Declara el boton btnSalir7

    @FXML
    public void btnSalir7OnAction(ActionEvent event) { //00103923 Declara el metodo void btnSalir7OnAction que recibe de parametros un event
        ((Stage)btnSalir7.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/menu-empleado.fxml"); //00103923 Cambia la escena usando SceneManager
    }

    @FXML
    public void btnDatosClientesOnAction(ActionEvent event) { //00103923 Declara el metodo void btnDatosClientesOnAction que recibe de parametros un event
        ((Stage)btnDatosClientes.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/datos-cliente.fxml"); //00103923 Cambia la escena usando SceneManager
    }

    @FXML
    public void btnTarjetasClientesOnAction(ActionEvent event) { //00103923 Declara el metodo void btnTarjetasClientesOnAction que recibe de parametros un event
        ((Stage)btnTarjetasClientes.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/tarjetas-cliente.fxml"); //00103923 Cambia la escena usando SceneManager
    }
}
