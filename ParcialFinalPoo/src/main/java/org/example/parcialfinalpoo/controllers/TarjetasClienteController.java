package org.example.parcialfinalpoo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.example.parcialfinalpoo.SceneManager;

public class TarjetasClienteController { //00103923 Declara la clase TarjetasClienteController
    @FXML
    private Button btnAgregarTarjeta; //00103923 Declara el boton btnAgregarTarjeta
    @FXML
    private Button btnEliminarTarjeta; //00103923 Declara el boton btnEliminarTarjeta
    @FXML
    private Button btnSalir9; //00103923 Declara el boton btnAceptarT

    @FXML
    public void btnSalir9OnAction(ActionEvent event) { //00103923 Declara el metodo void btnSalir9OnAction que recibe de parametros un event
        ((Stage)btnSalir9.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/menu-empleado.fxml"); //00103923 Cambia la escena usando SceneManager
    }

    @FXML
    public void btnAgregarTarjetaOnAction(ActionEvent event) { //00103923 Declara el metodo void btnAgregarTarjetaOnAction que recibe de parametros un event
        ((Stage)btnSalir9.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/agregar-tarjeta.fxml"); //00103923 Cambia la escena usando SceneManager
    }

    @FXML
    public void btnEliminarTarjetaOnAction(ActionEvent event) { //00103923 Declara el metodo void btnEliminarTarjetaOnAction que recibe de parametros un event
        ((Stage)btnSalir9.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/eliminar-tarjeta.fxml"); //00103923 Cambia la escena usando SceneManager
    }
}
