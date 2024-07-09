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

public class LoginEmpleadoController {
    @FXML
    private TextField txtFieldUser;
    @FXML
    private PasswordField pfPassword;
    @FXML
    private Button btnIngresar;
    @FXML
    private Button btnEscape;

    @FXML
    public void ingresar(ActionEvent event) {
        try {
            if (Authentication.authenticate(txtFieldUser.getText(), pfPassword.getText())) {
                ((Stage) btnIngresar.getScene().getWindow()).close(); // Cierra escena actual
                SceneManager.manageScene(event, "/org/example/parcialfinalpoo/menu-empleado.fxml");
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Usuario o contraseña incorrecto \n" + "Por favor intente nuevamente");
                alert.showAndWait(); // Mostrar la alerta al usuario
            }
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Ocurrió un error al intentar iniciar sesión: " + e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    public void escape(ActionEvent event) {
        ((Stage)btnEscape.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/login.fxml");
    }
}
