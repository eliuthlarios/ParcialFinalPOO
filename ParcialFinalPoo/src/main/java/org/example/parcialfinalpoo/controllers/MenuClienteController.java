package org.example.parcialfinalpoo.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import org.example.parcialfinalpoo.SceneManager;

import java.io.IOException;

public class MenuClienteController {
    @FXML
    private Button btnSalir2;
    @FXML
    private Button btnAceptar1;
    @FXML
    private TextField txtFieldNombreCliente1;
    @FXML
    private TextField txtFieldNumeroTarjeta;
    @FXML
    private TextField txtFieldMontoTransaccion;
    @FXML
    private TextArea txtAreaDescripcion;

    @FXML
    public void Salir2(ActionEvent event){
        ((Stage)txtAreaDescripcion.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/login.fxml");
    }
    @FXML
    public void btnAceptarOnClick(ActionEvent event) throws IOException {
        //Guardar la info en la base de datos

        ((Stage)txtAreaDescripcion.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/operacion-exitosa.fxml");
    }
}
