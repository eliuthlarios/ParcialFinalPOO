package org.example.parcialfinalpoo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.example.parcialfinalpoo.SceneManager;
import org.example.parcialfinalpoo.model.Authentication;

import java.io.IOException;
import java.sql.*;

public class LoginController {
    @FXML
    private Button btnCliente;
    @FXML
    private Button btnEmpleado;
    @FXML
    private Button btnSalir1;

    @FXML
    public void quit(){
        System.exit(0);
    }

    @FXML
    public void btnClienteOnAction(ActionEvent event) throws IOException {
        ((Stage)btnCliente.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event,"/org/example/parcialfinalpoo/menu-cliente.fxml");
    }
    @FXML
    public void btnEmpleadoOnAction(ActionEvent event) throws IOException {
        ((Stage)btnCliente.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/login-empleado.fxml");
    }
}