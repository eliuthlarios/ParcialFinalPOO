package org.example.parcialfinalpoo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.example.parcialfinalpoo.SceneManager;

import java.io.IOException;

public class ModificarClienteController {
    @FXML
    private Button btnAgregarCliente;
    @FXML
    private Button btnModificarCliente;
    @FXML
    private Button btnEliminarCliente;
    @FXML
    private Button btnSalir4;

    @FXML
    public void btnSalir4OnAction(ActionEvent event) {
        ((Stage)btnSalir4.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/login.fxml");
    }

    @FXML
    public void btnAgregarClienteOnAction(ActionEvent event) {
        ((Stage)btnSalir4.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/agregar-cliente.fxml");
    }

    @FXML
    public void btnModificarClienteOnAction(ActionEvent event) {
        ((Stage)btnSalir4.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/mod-datos-cliente.fxml");
    }

    @FXML
    public void btnEliminarClienteOnAction(ActionEvent event) {
        ((Stage)btnSalir4.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/eliminar-cliente.fxml");
    }
}
