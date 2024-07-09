package org.example.parcialfinalpoo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.parcialfinalpoo.SceneManager;
import org.example.parcialfinalpoo.model.Authentication;

public class LoginEmpleadoController { //00103923 Declara la clase LoginEmpleadoController
    @FXML
    private TextField txtFieldUser;//00103923 Declara el text field txtFieldUser
    @FXML
    private PasswordField pfPassword;//00103923 Declara el password field pfPassword
    @FXML
    private Button btnIngresar;//00103923 Declara el boton btnIngresar
    @FXML
    private Button btnEscape; //00103923 Declara el boton btnEscape

    @FXML
    public void ingresar(ActionEvent event) { //00103923 Declara el metodo void ingresar que recibe de parametros un event
        try { //00103923 Inicio del try
            if (Authentication.authenticate(txtFieldUser.getText(), pfPassword.getText())) { //00103923 Verifica si las credenciales son correctas por medio de Authentication
                ((Stage) btnIngresar.getScene().getWindow()).close(); // Cierra escena actual
                SceneManager.manageScene(event, "/org/example/parcialfinalpoo/menu-empleado.fxml"); //00103923 Cambia la escena usando SceneManager
            } else { //00103923 En caso de que las creenciales sean incorrectas
                Alert alert = new Alert(Alert.AlertType.ERROR); //00103923 Crea una nueva alerta tipo ERROR
                alert.setTitle("Error"); //00103923 Pone el título de la alerta a Error
                alert.setHeaderText(null); //00103923 Deja el encabezado vacio
                alert.setContentText("Usuario o contraseña incorrecto \n" + "Por favor intente nuevamente"); //00103923 Establece el contenido del mesaje de la alerta
                alert.showAndWait(); //00103923 Mostrar la alerta al usuario
            }
        } catch (Exception e) { //00103923 Captura cualquier excepcion
            e.printStackTrace(); //00103923 Muestra el seguimiento del error
            Alert alert = new Alert(Alert.AlertType.ERROR); //00103923 Crea una nueva alerta tipo ERROR
            alert.setTitle("Error"); //00103923 Pone el título de la alerta a Error
            alert.setHeaderText(null); //00103923 Deja el encabezado vacio
            alert.setContentText("Ocurrió un error al intentar iniciar sesión: " + e.getMessage());  //00103923 Establece el contenido del mesaje de la alerta
            alert.showAndWait(); //00103923 Mostrar la alerta al usuario
        }
    }

    @FXML
    public void escape(ActionEvent event) { //00103923 Declara el metodo void escape que recibe de parametros un event
        ((Stage)btnEscape.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/login.fxml"); //00103923 Cambia la escena usando SceneManager
    }
}
