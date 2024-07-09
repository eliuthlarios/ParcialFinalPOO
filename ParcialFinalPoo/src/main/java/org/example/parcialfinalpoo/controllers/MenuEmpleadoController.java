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


public class MenuEmpleadoController {
    @FXML
    private Button btnSalir3;
    @FXML
    private Button btnModificarClientes;
    @FXML
    private Button btnReportes;

    @FXML
    public void btnSalir3OnAction(ActionEvent event) {
        ((Stage)btnSalir3.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/login.fxml");
    }

    @FXML
    public void btnModificarClientesOnAction(ActionEvent event) {
        ((Stage)btnSalir3.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event,"/org/example/parcialfinalpoo/modificar-cliente.fxml");
    }

    @FXML
    public void btnReportesOnAction(ActionEvent event) {
        ((Stage)btnSalir3.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/generar-reportes.fxml");
    }
}
