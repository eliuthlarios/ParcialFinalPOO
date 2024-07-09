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

public class ModDatosClienteController {
    @FXML
    private Button btnDatosClientes;
    @FXML
    private Button btnTarjetasClientes;
    @FXML
    private Button btnSalir7;

    @FXML
    public void btnSalir7OnAction(ActionEvent event) {
        ((Stage)btnSalir7.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/menu-empleado.fxml");
    }

    @FXML
    public void btnDatosClientesOnAction(ActionEvent event) {
        ((Stage)btnDatosClientes.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/datos-cliente.fxml");
    }

    @FXML
    public void btnTarjetasClientesOnAction(ActionEvent event) {
        ((Stage)btnTarjetasClientes.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/tarjetas-cliente.fxml");
    }
}
