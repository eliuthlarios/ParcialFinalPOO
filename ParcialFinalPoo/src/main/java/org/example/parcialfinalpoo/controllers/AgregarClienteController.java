package org.example.parcialfinalpoo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.parcialfinalpoo.SceneManager;

public class AgregarClienteController {
    @FXML
    private TextField txtFieldNombreCliente2;
    @FXML
    private TextArea txtAreaDireccion1;
    @FXML
    private TextField txtFieldTelefono1;
    @FXML
    private Button btnAgregar1;
    @FXML
    private Button btnSalir6;

    @FXML
    public void agregarOnAction(ActionEvent event) {
        //Agregar cliente


        ((Stage)btnAgregar1.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/operacion-exitosa.fxml");
    }

    @FXML
    public void btnSalir6OnAction(ActionEvent event) {
        ((Stage)btnSalir6.getScene().getWindow()).close();
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/menu-empleado.fxml");
    }
}
