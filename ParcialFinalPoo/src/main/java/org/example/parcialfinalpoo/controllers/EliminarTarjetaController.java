package org.example.parcialfinalpoo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.example.parcialfinalpoo.SceneManager;


public class EliminarTarjetaController {
    @FXML
    private TextField txtFieldNumeroTarjeta2;
    @FXML
    private Button btnEliminar1;
    @FXML
    private Button btnSalir11;

    @FXML
    public void btnEliminar1OnAction(ActionEvent event) {
        //Eliminar tarjeta


        ((Stage)btnEliminar1.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/operacion-exitosa.fxml");
    }
    @FXML
    public void btnSalir11OnAction(ActionEvent event) {
        ((Stage)btnSalir11.getScene().getWindow()).close();
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/login.fxml");
    }
}
