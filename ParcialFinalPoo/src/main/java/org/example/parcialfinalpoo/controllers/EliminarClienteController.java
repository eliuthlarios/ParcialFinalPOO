package org.example.parcialfinalpoo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.parcialfinalpoo.SceneManager;

public class EliminarClienteController {
    @FXML
    private TextField txtFieldIDCliente;
    @FXML
    private Button btnEliminar2;
    @FXML
    private Button btnSalir12;

    @FXML
    public void btnSalir12OnAction(ActionEvent event) {
        ((Stage)btnSalir12.getScene().getWindow()).close();
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/login.fxml");
    }

    @FXML
    public void btnEliminar2OnAction(ActionEvent event) {
        //Eliminar cliente


        ((Stage)btnEliminar2.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/operacion-exitosa.fxml");
    }
}
