package org.example.parcialfinalpoo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.example.parcialfinalpoo.SceneManager;


public class EliminarTarjetaController { //00103923 Declara la clase EliminarTarjetaController
    @FXML
    private TextField txtFieldNumeroTarjeta2; //00103923 Declara el text field txtFieldNumeroTarjeta2
    @FXML
    private Button btnEliminar1; //00103923 Declara el boton btnEliminar1
    @FXML
    private Button btnSalir11; //00103923 Declara el boton btnSalir11

    @FXML
    public void btnEliminar1OnAction(ActionEvent event) { //00103923 Declara el metodo void btnEliminar1OnAction que recibe de parametros un event
        //Eliminar tarjeta


        ((Stage)btnEliminar1.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/operacion-exitosa.fxml"); //00103923 Cambia la escena usando SceneManager
    }
    @FXML
    public void btnSalir11OnAction(ActionEvent event) { //00103923 Declara el metodo void btnSalir11OnAction que recibe de parametros un event
        ((Stage)btnSalir11.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/menu-empleado.fxml"); //00103923 Cambia la escena usando SceneManager
    }
}
