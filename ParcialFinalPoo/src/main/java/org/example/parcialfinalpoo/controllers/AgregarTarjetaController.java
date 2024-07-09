package org.example.parcialfinalpoo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.parcialfinalpoo.SceneManager;

public class AgregarTarjetaController {
    @FXML
    private TextField txtFieldNumeroTarjeta1;
    @FXML
    private TextField txtFieldExpiracionTarjeta;
    @FXML
    private TextField txtFieldTipoTarjeta;
    @FXML
    private TextField txtFacilitador;
    @FXML
    private Button btnAgregar2;
    @FXML
    private Button btnSalir10;

    @FXML
    public void agregarTarjeta(ActionEvent event) {
        //Agregar tarjeta


        ((Stage)btnAgregar2.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/operacion-exitosa.fxml");
    }

    @FXML
    public void btnSalir10OnAction(ActionEvent event) {
        ((Stage)btnSalir10.getScene().getWindow()).close();
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/menu-empleado.fxml");
    }
}
