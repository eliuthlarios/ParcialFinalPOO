package org.example.parcialfinalpoo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.example.parcialfinalpoo.BDConection;
import org.example.parcialfinalpoo.SceneManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.example.parcialfinalpoo.AlertControllers.MostrarError;//00106423 Importamos la clase abstracta AlertControlles y su funcion static MostrarError


public class EliminarTarjetaController {//00103923 Declara la clase EliminarTarjetaController
    @FXML
    private TextField txtFieldNumeroTarjeta2;//00103923 Declara el text field txtFieldNumeroTarjeta2
    @FXML
    private Button btnEliminar1;//00103923 Declara el boton btnEliminar1
    @FXML
    private Button btnSalir11;//00103923 Declara el boton btnSalir11

    @FXML
    public void btnEliminar1OnAction(ActionEvent event) {//00103923 Declara el metodo void btnEliminar1OnAction que recibe de parametros un event

        String SQL_query = "delete from Tarjetas where NumeroTarjeta=?";//00106423 Escribimos la query que eliminara una tarjeta  de la BD
        String NumeroTarjeta=txtFieldNumeroTarjeta2.getText();//00106423 Guardamos en una variable el valor del textField que recibe el numero de tarjeta del usuario

        if(NumeroTarjeta.isEmpty()){//00106423 Hacemos un if para verificar que el campo solicitado este rellenado
            MostrarError("ERROR AL ELIMINAR TARJETA", "RELLENA EL CAMPO SOLICITADO");//00106423 Hacemos uso de la funcion importada MostrarError
            return;//00106423 Salimos del metodo
        }

        try (Connection conn = BDConection.getConnection();//00106423 En un bloque try-catch manipulamos la BD y abrimos la coneccion
             PreparedStatement pstm = conn.prepareStatement(SQL_query)) {//00106423 Le pasamos la query

            pstm.setString(1, NumeroTarjeta);//00106423 Agregamos el numero de tarjeta esctrito por el usuario en el text label a la query
            int rowsAffected = pstm.executeUpdate();//00106423 Ejecutamos la query y guardamos la cantidad de filas que retorna la funcion excuteUpdate

            if (rowsAffected > 0) {//00106423 Si ha modificado mas de 0 filas significa que se ha eliminado la tarjeta correctamente

                ((Stage) btnEliminar1.getScene().getWindow()).close();//00103923 Cierra escena actual
                SceneManager.manageScene(event, "/org/example/parcialfinalpoo/operacion-exitosa.fxml"); //00103923 Cambia la escena usando SceneManager
                BDConection.closeConnection();//00106423 Cerramos la coneccion despues de eliminar la tarjeta
            } else {
                MostrarError("ERROR AL ELIMINAR TARJETA", "INGRESE UNA TARJETA EXISTENTE");//00106423 Hacemos uso de la funcion importada MostrarError
            }

        } catch (SQLException e) {
            MostrarError("ERROR AL EIMINAR TARJETA", "INTENTE NUEVAMENTE");//00106423 Hacemos uso de la funcion importada MostrarError
        }
    }
    @FXML
    public void btnSalir11OnAction(ActionEvent event) {//00103923 Declara el metodo void btnSalir11OnAction que recibe de parametros un event
        ((Stage)btnSalir11.getScene().getWindow()).close();//00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/menu-empleado.fxml");//00103923 Cambia la escena usando SceneManager
    }

}
