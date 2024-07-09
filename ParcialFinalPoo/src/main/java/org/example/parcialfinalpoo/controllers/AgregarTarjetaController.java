package org.example.parcialfinalpoo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.parcialfinalpoo.SceneManager;

public class AgregarTarjetaController { //00103923 Declara la clase AgregarTarjetaController
    @FXML
    private TextField txtFieldNumeroTarjeta1; //00103923 Declara el text field txtFieldNumeroTarjeta1
    @FXML
    private TextField txtFieldExpiracionTarjeta; //00103923 Declara el text field txtFieldExpiracionTarjeta
    @FXML
    private TextField txtFieldTipoTarjeta; //00103923 Declara el text field txtFieldTipoTarjeta
    @FXML
    private TextField txtFacilitador; //00103923 Declara el text field txtFacilitador
    @FXML
    private Button btnAgregar2; //00103923 Declara el boton btnAgregar2
    @FXML
    private Button btnSalir10; //00103923 Declara el boton btnSalir10

    @FXML
    public void agregarTarjeta(ActionEvent event) { //00103923 Declara el metodo void agregarTarjeta que recibe de parametros un event
        //Agregar tarjeta


        ((Stage)btnAgregar2.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/operacion-exitosa.fxml"); //00103923 Cambia la escena usando SceneManager
    }

    @FXML
    public void btnSalir10OnAction(ActionEvent event) { //00103923 Declara el metodo void btnSalir10OnAction que recibe de parametros un event
        ((Stage)btnSalir10.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/menu-empleado.fxml"); //00103923 Cambia la escena usando SceneManager
    }
}
