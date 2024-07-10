package org.example.parcialfinalpoo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.example.parcialfinalpoo.SceneManager;

public class TransaccionExitosaController { //00103923 Declara la clase TransaccionExitosaController
    @FXML
    private Button btnAceptarT; //00103923 Declara el boton btnAceptarT

    @FXML
    public void btnAceptarTOnClick(ActionEvent event) { //00103923 Declara el metodo void btnAceptarTOnClick que recibe de parametros un event
        ((Stage)btnAceptarT.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/login.fxml"); //00103923 Cambia la escena usando SceneManager
    }
}
