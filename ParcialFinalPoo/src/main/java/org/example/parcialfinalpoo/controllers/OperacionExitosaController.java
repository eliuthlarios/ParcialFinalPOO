package org.example.parcialfinalpoo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.example.parcialfinalpoo.SceneManager;

public class OperacionExitosaController { //00103923 Declara la clase OperacionExitosaController
    @FXML
    private Button btnAceptar2; //00103923 Declara el boton btnAceptar2

    @FXML
    public void btnAceptarOnClick(ActionEvent event) { //00103923 Declara el metodo void btnAceptarOnClick que recibe de parametros un event
        ((Stage)btnAceptar2.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/menu-empleado.fxml"); //00103923 Cambia la escena usando SceneManager
    }
}
