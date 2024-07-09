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

public class AgregarTarjetaController {//00103923 Declara la clase AgregarTarjetaController
    @FXML
    private TextField txtFieldNumeroTarjeta1;//00103923 Declara el text field txtFieldNumeroTarjeta1
    @FXML
    private TextField txtFieldExpiracionTarjeta;//00103923 Declara el text field txtFieldExpiracionTarjeta
    @FXML
    private TextField txtFieldTipoTarjeta; //00103923 Declara el text field txtFieldTipoTarjeta
    @FXML
    private TextField txtFacilitador;//00103923 Declara el text field txtFacilitador
    @FXML
    private TextField txtClienteID; //00106423 Agregamos un campo para que el usuario ingrese el id del cliente
    @FXML
    private Button btnAgregar2;//00103923 Declara el boton btnAgregar2
    @FXML
    private Button btnSalir10;//00103923 Declara el boton btnSalir10


    @FXML
    public void agregarTarjeta(ActionEvent event) {//00103923 Declara el metodo void agregarTarjeta que recibe de parametros un event

        String SQL_query = "insert into Tarjetas(NumeroTarjeta,FechaExpiracion,TipoTarjeta,Facilitador,ClienteID) values(?,?,?,?,?)"; //00106423 Escribimos la query que agregara tarjetas a la BD
        String NumeroTarjeta = txtFieldNumeroTarjeta1.getText();//00106423 Guardamos en una variable el valor del textField que recibe el numero de tarjeta del usuario
        String FechaExpiracion = txtFieldExpiracionTarjeta.getText();//00106423 Guardamos en una variable el valor del textField que recibe el numero de tarjeta del usuario
        String TipoTarjeta = txtFieldTipoTarjeta.getText();//00106423 Guardamos en una variable el valor del textField que recibe el tipo de tarjeta del usuario
        String Facilitador = txtFacilitador.getText();//00106423 Guardamos en una variable el valor del textField que recibe el facilitador del usuario
        int ClienteID = 0;//00106423 Declaramos y definimos una variable que almacene el id del cliente


        if (NumeroTarjeta.isEmpty() || FechaExpiracion.isEmpty() || TipoTarjeta.isEmpty() || Facilitador.isEmpty()) {//00106423 Hacemos un if para verificar que todos los datos esten rellenados
            MostrarError("ERROR AL AGREGAR TARJETA", "VERIFICA QUE LOS DATOS AGREGADOS SEAN VALIDOS");//00106423 Hacemos uso de la funcion importada MostrarError
            return;//00106423 Salimos del metodo
        }

        try {//00106423 Definimos el valor de id del cliente dentro de un try-catch
            ClienteID = Integer.parseInt(txtClienteID.getText());//00106423 Definimos nuevamente el id del cliente con el que el usuario digito y lo casteamos a un tipo int
        } catch (NumberFormatException e) {
            MostrarError("ERROR AL AGREGAR TARJETA", "VERIFICA QUE EL ID DE CLIENTE SEA VALIDO");//00106423 Hacemos uso de la funcion importada MostrarError
            return;//00106423 Salimos del metodo
        }

        try (Connection conn = BDConection.getConnection();//00106423 En un bloque try-catch manipulamos la BD y abrimos la coneccion
             PreparedStatement pstm = conn.prepareStatement(SQL_query)) {//00106423 Le pasamos la query

            //00106423 Agregamos los datos escritos por el usuario en los text labels a la query
            pstm.setString(1, NumeroTarjeta);
            pstm.setString(2, FechaExpiracion);
            pstm.setString(3, TipoTarjeta);
            pstm.setString(4, Facilitador);
            pstm.setInt(5, ClienteID);

            int rowsAffected = pstm.executeUpdate();//00106423 Ejecutamos la query y guardamos la cantidad de filas que retorna la funcion excuteUpdate
            if (rowsAffected > 0) {//00106423 Si ha modificado mas de 0 filas significa que se ha agregado la tarjeta correctamente

                ((Stage) btnAgregar2.getScene().getWindow()).close();//00103923 Cierra escena actual
                SceneManager.manageScene(event, "/org/example/parcialfinalpoo/operacion-exitosa.fxml");
                BDConection.closeConnection();//00106423 Cerramos la connecion a la BD
            } else {
                MostrarError("ERROR AL AGREGAR TARJETA", "INTENTE NUEVAMENTE");//00106423 Hacemos uso de la funcion importada MostrarError
            }

        } catch (SQLException e) {
          MostrarError("ERROR AL AGREGAR TARJETA", "INGRESA UN ID DE USUARIO EXISTENTE");//00106423 Hacemos uso de la funcion importada MostrarError
        }
    }

    @FXML
    public void btnSalir10OnAction(ActionEvent event) {//00103923 Declara el metodo void btnSalir10OnAction que recibe de parametros un event
        ((Stage)btnSalir10.getScene().getWindow()).close();//00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/menu-empleado.fxml");//00103923 Cambia la escena usando SceneManager
    }


    }