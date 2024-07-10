package org.example.parcialfinalpoo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.example.parcialfinalpoo.SceneManager;

public class LoginController { //00103923 Declara la clase LoginController
    @FXML
    private Button btnCliente; //00103923 Declara el boton btnCliente
    @FXML
    private Button btnEmpleado; //00103923 Declara el boton btnEmpleado
    @FXML
    private Button btnSalir1; //00103923 Declara el boton btnSalir1

    @FXML
    public void quit(){ //00103923 Declara el metodo void quit
        System.exit(0); //00103923 Finaliza la ejecucion de la aplicacion
    }

    @FXML
    public void btnClienteOnAction(ActionEvent event){ //00103923 Declara el metodo void btnClienteOnAction que recibe de parametros un event
        ((Stage)btnCliente.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event,"/org/example/parcialfinalpoo/menu-cliente.fxml"); //00103923 Cambia la escena usando SceneManager
    }
    @FXML
    public void btnEmpleadoOnAction(ActionEvent event){ //00103923 Declara el metodo void btnEmpleadoOnAction que recibe de parametros un event
        ((Stage)btnCliente.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/login-empleado.fxml"); //00103923 Cambia la escena usando SceneManager
    }
}