package org.example.parcialfinalpoo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.example.parcialfinalpoo.SceneManager;

public class OperacionNoExistosaController {
    @FXML
    private Button btnAceptar2;
    public void btnAceptarOnClick(ActionEvent event) {
        ((Stage)btnAceptar2.getScene().getWindow()).close();
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/login.fxml");
    }

}
