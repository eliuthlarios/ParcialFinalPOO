package org.example.parcialfinalpoo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.example.parcialfinalpoo.SceneManager;

public class TarjetasClienteController {
    @FXML
    private Button btnAgregarTarjeta;
    @FXML
    private Button btnEliminarTarjeta;
    @FXML
    private Button btnSalir9;

    @FXML
    public void btnSalir9OnAction(ActionEvent event) {
        ((Stage)btnSalir9.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/menu-empleado.fxml");
    }

    @FXML
    public void btnAgregarTarjetaOnAction(ActionEvent event) {
        ((Stage)btnSalir9.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/agregar-tarjeta.fxml");
    }

    @FXML
    public void btnEliminarTarjetaOnAction(ActionEvent event) {
        ((Stage)btnSalir9.getScene().getWindow()).close();
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/eliminar-tarjeta.fxml");
    }
}
