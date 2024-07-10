package org.example.parcialfinalpoo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.parcialfinalpoo.BDConection;
import org.example.parcialfinalpoo.SceneManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.example.parcialfinalpoo.AlertControllers.MostrarError;//00106423 Importamos la clase abstracta AlertControlles y su funcion static MostrarError

public class EliminarClienteController {//00103923 Declara la clase EliminarClienteController
    @FXML
    private TextField txtFieldIDCliente;//00103923 Declara el text field txtFieldIDCliente
    @FXML
    private Button btnEliminar2;//00103923 Declara el boton btnEliminar2
    @FXML
    private Button btnSalir12;//00103923 Declara el boton btnSalir12

    @FXML
    public void btnSalir12OnAction(ActionEvent event) {//00103923 Declara el metodo void btnSalir12OnAction que recibe de parametros un event
        ((Stage) btnSalir12.getScene().getWindow()).close();//00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/menu-empleado.fxml");//00103923 Cambia la escena usando SceneManager

    }

    @FXML
    public void btnEliminar2OnAction(ActionEvent event) {//00103923 Declara el metodo void btnEliminar2OnAction que recibe de parametros un event

        String SQL_query = "DELETE FROM Clientes WHERE ClienteID = ?"; //00106423 Escribimos la query que eliminara un cliente de la BD
        int clienteID = 0;//00106423 Declaramos y definimos una variable que almacene el id del cliente

        try {//00106423 Definimos el valor de id del cliente dentro de un try-catch
            clienteID = Integer.parseInt(txtFieldIDCliente.getText());//00106423 Definimos nuevamente el id del cliente con el que el usuario digito y lo casteamos a un tipo int
        } catch (NumberFormatException e) {
            MostrarError("ERROR AL ELIMINAR CLIENTE", "VERIFICA QUE EL ID DE CLIENTE SEA VÁLIDO");//00106423 Hacemos uso de la funcion importada MostrarError
            return; //00106423 Salimos del metodo
        }

        if (txtFieldIDCliente.getText().isEmpty()) {//00106423 Hacemos un if para verificar que el campo solicitado este rellenado
            MostrarError("ERROR AL ELIMINAR CLIENTE", "RELLENA EL CAMPO SOLICITADO");//00106423 Hacemos uso de la funcion importada MostrarError
            return; //00106423 Salimos del metodo
        }


        try (Connection conn = BDConection.getConnection();//00106423 En un bloque try-catch manipulamos la BD y abrimos la coneccion
             PreparedStatement pstm = conn.prepareStatement(SQL_query)) {//00106423 Le pasamos la query

            pstm.setInt(1, clienteID);//00106423 Agregamos el id escrito por el usuario en el text label a la query
            int rowsAffected = pstm.executeUpdate();//00106423 Ejecutamos la query y guardamos la cantidad de filas que retorna la funcion excuteUpdate

            if (rowsAffected > 0) {//00106423 Si ha modificado mas de 0 filas significa que se ha eliminado el cliente correctamente

                ((Stage) btnEliminar2.getScene().getWindow()).close();//00103923 Cierra escena actual
                SceneManager.manageScene(event, "/org/example/parcialfinalpoo/operacion-exitosa.fxml");//00103923 Cambia la escena usando SceneManager

                BDConection.closeConnection();//00106423 Cerramos la coneccion despues de eliminar el cliente
            } else {
                MostrarError("ERROR AL ELIMINAR CLIENTE", "NO SE ENCONTRÓ NINGÚN CLIENTE CON ESE ID");//00106423 Hacemos uso de la funcion importada MostrarError
            }

        } catch (SQLException e) {
            MostrarError("ERROR AL ELIMINAR CLIENTE", "VERIFICA QUE EL ID DE USUARIO EXISTE");//00106423 Hacemos uso de la funcion importada MostrarError

        }
    }


}
