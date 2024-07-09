package org.example.parcialfinalpoo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.example.parcialfinalpoo.SceneManager;

public class ModificarClienteController { //00103923 Declara la clase ModificarClienteController
    @FXML
    private Button btnAgregarCliente; //00103923 Declara el boton btnAgregarCliente
    @FXML
    private Button btnModificarCliente; //00103923 Declara el boton btnModificarCliente
    @FXML
    private Button btnEliminarCliente; //00103923 Declara el boton btnEliminarCliente
    @FXML
    private Button btnSalir4; //00103923 Declara el boton btnSalir4

    @FXML
    public void btnSalir4OnAction(ActionEvent event) { //00103923 Declara el metodo void btnSalir4OnAction que recibe de parametros un event
        ((Stage)btnSalir4.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/menu-empleado.fxml"); //00103923 Cambia la escena usando SceneManager
    }

    @FXML
    public void btnAgregarClienteOnAction(ActionEvent event) { //00103923 Declara el metodo void btnAgregarClienteOnAction que recibe de parametros un event
        ((Stage)btnSalir4.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/agregar-cliente.fxml"); //00103923 Cambia la escena usando SceneManager
    }

    @FXML
    public void btnModificarClienteOnAction(ActionEvent event) { //00103923 Declara el metodo void btnModificarClienteOnAction que recibe de parametros un event
        ((Stage)btnSalir4.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/mod-datos-cliente.fxml"); //00103923 Cambia la escena usando SceneManager
    }

    @FXML
    public void btnEliminarClienteOnAction(ActionEvent event) { //00103923 Declara el metodo void btnEliminarClienteOnAction que recibe de parametros un event
        ((Stage)btnSalir4.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/eliminar-cliente.fxml"); //00103923 Cambia la escena usando SceneManager
    }
}
