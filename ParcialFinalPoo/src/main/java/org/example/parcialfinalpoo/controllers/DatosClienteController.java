package org.example.parcialfinalpoo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.parcialfinalpoo.SceneManager;

public class DatosClienteController { //00103923 Declara la clase DatosClienteController
    @FXML
    private TextField txtFieldNombreCliente3; //00103923 Declara el text field txtFieldNombreCliente3
    @FXML
    private TextArea txtAreaDireccion2; //00103923 Declara el text field txtAreaDireccion2
    @FXML
    private TextField txtFieldTelefono2; //00103923 Declara el text field txtFieldTelefono2
    @FXML
    private Button btnConfirmar; //00103923 Declara el boton btnConfirmar
    @FXML
    private Button btnSalir8; //00103923 Declara el boton btnSalir8

    @FXML
    public void btnConfirmarOnAction(ActionEvent event) { //00103923 Declara el metodo void btnConfirmarOnAction que recibe de parametros un event
        //Modificar cliente


        ((Stage)btnConfirmar.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/operacion-exitosa.fxml"); //00103923 Cambia la escena usando SceneManager
    }

    @FXML
    public void btnSalir8OnAction(ActionEvent event) { //00103923 Declara el metodo void btnSalir8OnAction que recibe de parametros un event
        ((Stage)btnSalir8.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/menu-empleado.fxml"); //00103923 Cambia la escena usando SceneManager
    }
}
