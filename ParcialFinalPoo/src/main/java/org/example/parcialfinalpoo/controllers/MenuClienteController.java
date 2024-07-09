package org.example.parcialfinalpoo.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import org.example.parcialfinalpoo.BDConection;
import org.example.parcialfinalpoo.SceneManager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//00029223 en esta clase simulara la compra de un cliente en el cual se ingresaran los datos
public class MenuClienteController {

    @FXML
    private TextField txtFieldNombreCliente1; //00029223 nombre del cliente
    @FXML
    private TextField txtFieldNumeroTarjeta; //00029223 numero de tarjeta
    @FXML
    private TextField txtFieldMontoTransaccion; //00029223 monto
    @FXML
    private TextArea txtAreaDescripcion; //00029223 descripcion
    @FXML
    private Button btnAceptar1; //00029223 realizar transaccion
    @FXML
    private Button btnSalir2; //00029223 salir


    // 0029223 Metodo para insertar una transaccion a la base de datos a traves de un procedimiento almacenado (PA)
    private void insertarTransaccion(String numeroTarjeta, double montoTotal, String descripcion) throws SQLException{ //00029223 puede lanzar una sqlexcepcion
        String sql = "{call InsertarTransaccion(?, ?, ?)}"; //00029223 define la llamada al procedimiento almacenado

        try (Connection conn = BDConection.getConnection(); //00029223 obtiene la conexión a la bd
             PreparedStatement stmt = conn.prepareStatement(sql)) { //00029223 Prepara el query

            stmt.setString(1, numeroTarjeta); //00029223 establece el primer parámetro del PA
            stmt.setDouble(2, montoTotal); //00029223 establece el segundo
            stmt.setString(3, descripcion); //00029223 establece el tercero

            stmt.executeUpdate(); //00029223 ejecuta la insercion a la bd
        }
    }
    //00029223 metodo para mostrar alerta
    private void mostrarAlerta(String titulo, String contenido, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo); //00029223 crea la alerta segun el tipo
        alert.setTitle(titulo); //00029223 establece el titulo
        alert.setContentText(contenido); //00029223 setea el contenido a mostrar
        alert.showAndWait(); //00029223 muestra y espera
    }
    @FXML
    public void Salir2(ActionEvent event){
        ((Stage)txtAreaDescripcion.getScene().getWindow()).close(); //00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/login.fxml"); //00029223 Cambia a la escena del login
    }
    @FXML
    public void btnAceptarOnClick(ActionEvent event) throws IOException {
        String numeroTarjeta = txtFieldNumeroTarjeta.getText(); //00029223 saca el texto del campo de la tarjeta
        String montoTransaccionStr = txtFieldMontoTransaccion.getText(); //00029223 saca el texto del campo del monto
        String descripcion = txtAreaDescripcion.getText(); //00029223 saca el texto de la descripcion

        if (numeroTarjeta.isEmpty() || montoTransaccionStr.isEmpty() || descripcion.isEmpty()) {  //00029223 evalua que los 3 campos no esten vacios
            mostrarAlerta("Error", "Debe llenar los campos, porfavor.", Alert.AlertType.ERROR); //00029223 lanza una advertencia de que debe llenarlos
            return;  //00029223 retorna si hay campos vacios
        }

        try {
            double montoTransaccion = Double.parseDouble(montoTransaccionStr); //00029223 convierte el texto del monto a un numero

            try {
                insertarTransaccion(numeroTarjeta, montoTransaccion, descripcion); //00029223 inserta a la base de datos
                mostrarAlerta("Nice", "Transaccion Realizada.", Alert.AlertType.INFORMATION); //00029223 muestra una alerta de exito
                SceneManager.manageScene(event, "/org/example/parcialfinalpoo/operacion-exitosa.fxml"); //00029223 cambia a la escena de operación exitosa
            } catch (SQLException v ) {
                mostrarAlerta("No se pudo realizar la transaccion", "" + v.getMessage(), Alert.AlertType.ERROR); //00029223 muestra el mensaje del try catch del PA
                SceneManager.manageScene(event, "/org/example/parcialfinalpoo/operacion-noexitosa.fxml"); //00029223 cambia a la escena de operación no exitosa
            }

        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "El monto es invalido, ingrese numeros.", Alert.AlertType.ERROR); //00029223 muestra alerta de error por el formato del numero
            SceneManager.manageScene(event, "/org/example/parcialfinalpoo/operacion-noexitosa.fxml"); //00029223 cambia a la escena de operación no exitosa
        }

        ((Stage)txtAreaDescripcion.getScene().getWindow()).close(); //00103923 Cierra escena actual
         SceneManager.manageScene(event, "/org/example/parcialfinalpoo/operacion-exitosa.fxml"); //00029223 cambia a la scena de operacion exitosa
    }

}
