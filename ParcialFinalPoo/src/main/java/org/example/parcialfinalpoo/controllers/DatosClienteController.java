package org.example.parcialfinalpoo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.parcialfinalpoo.SceneManager;

public class DatosClienteController {
    @FXML
    private TextField txtFieldNombreCliente3;
    @FXML
    private TextArea txtAreaDireccion2;
    @FXML
    private TextField txtFieldTelefono2;
    @FXML
    private Button btnConfirmar;
    @FXML
    private Button btnSalir8;

    @FXML
    public void btnConfirmarOnAction(ActionEvent event) {
        //Modificar cliente


        ((Stage)btnConfirmar.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/operacion-exitosa.fxml");
    }

    @FXML
    public void btnSalir8OnAction(ActionEvent event) {
        ((Stage)btnSalir8.getScene().getWindow()).close();
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/menu-empleado.fxml");
    }
}
