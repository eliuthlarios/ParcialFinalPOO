package org.example.parcialfinalpoo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.parcialfinalpoo.SceneManager;

public class EliminarClienteController { //00103923 Declara la clase EliminarClienteController
    @FXML
    private TextField txtFieldIDCliente; //00103923 Declara el text field txtFieldIDCliente
    @FXML
    private Button btnEliminar2; //00103923 Declara el boton btnEliminar2
    @FXML
    private Button btnSalir12; //00103923 Declara el boton btnSalir12

    @FXML
    public void btnSalir12OnAction(ActionEvent event) { //00103923 Declara el metodo void btnSalir12OnAction que recibe de parametros un event
        ((Stage)btnSalir12.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/menu-empleado.fxml"); //00103923 Cambia la escena usando SceneManager
    }

    @FXML
    public void btnEliminar2OnAction(ActionEvent event) { //00103923 Declara el metodo void btnEliminar2OnAction que recibe de parametros un event
        //Eliminar cliente


        ((Stage)btnEliminar2.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/operacion-exitosa.fxml"); //00103923 Cambia la escena usando SceneManager
    }
}
