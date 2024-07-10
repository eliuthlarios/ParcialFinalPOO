package org.example.parcialfinalpoo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.parcialfinalpoo.BDConection;
import org.example.parcialfinalpoo.SceneManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.example.parcialfinalpoo.AlertControllers.MostrarError;//00106423 Importamos la clase abstracta AlertControlles y su funcion static MostrarError

public class DatosClienteController {//00103923 Declara la clase DatosClienteController
    @FXML
    private TextField txtFieldNombreCliente3;//00103923 Declara el text field txtFieldNombreCliente3
    @FXML
    private TextArea txtAreaDireccion2;//00103923 Declara el text field txtAreaDireccion2
    @FXML
    private TextField txtFieldTelefono2;//00103923 Declara el text field txtFieldTelefono2
    @FXML
    private TextField txtFieldClienteID2;//00106423 Agregamos un campo para que el usuario ingrese el id del cliente
    @FXML
    private Button btnConfirmar;//00103923 Declara el boton btnConfirmar
    @FXML
    private Button btnSalir8;//00103923 Declara el boton btnSalir8

    @FXML
    public void btnConfirmarOnAction(ActionEvent event) {//00103923 Declara el metodo void btnConfirmarOnAction que recibe de parametros un event

        String SQL_query = "update Clientes set NombreCompleto=?,Direccion=?,NumeroTelefono= ? where ClienteID=?";//00106423 Escribimos la query que modificara clientes de la BD
        String NombreCompleto=txtFieldNombreCliente3.getText();//00106423 Guardamos en una variable el valor del textField que recibe el nombre completo del usuario
        String Direccion=txtAreaDireccion2.getText();//00106423 Guardamos en una variable el valor del textField que recibe la direccion del usuario
        String NumerTelefono=txtFieldTelefono2.getText();//00106423 Guardamos en una variable el valor del textField que recibe el numero de telefono del usuario
        int clienteID=0;//00106423 Declaramos y definimos una variable que almacene el id del cliente

        try {//00106423 Definimos el valor de id del cliente dentro de un try-catch
            clienteID = Integer.parseInt(txtFieldClienteID2.getText());//00106423 Definimos nuevamente el id del cliente con el que el usuario digito y lo casteamos a un tipo int
        } catch (NumberFormatException e) {
            MostrarError("ERROR AL MODIFICAR CLIENTE", "VERIFICA QUE EL ID DE CLIENTE SEA VÁLIDO");//00106423 Hacemos uso de la funcion importada MostrarError
            return; //00106423 Salimos del metodo
        }

        if(NombreCompleto.isEmpty() || Direccion.isEmpty() || NumerTelefono.isEmpty()||txtFieldClienteID2.getText().isEmpty()){//00106423 Hacemos un if para verificar que todos los datos esten rellenados
            MostrarError("ERROR AL MODIFICAR CLIENTE", "RELLENA LOS CAMPOS SOLICITADOS");//00106423 Hacemos uso de la funcion importada MostrarError
            return;//00106423 Salimos del metodo
        }

        try (Connection conn = BDConection.getConnection();//00106423 En un bloque try-catch manipulamos la BD y abrimos la coneccion
             PreparedStatement pstm = conn.prepareStatement(SQL_query)) {//00106423 Le pasamos la query

            //00106423 Agregamos los datos escritos por el usuario en los text labels a la query
            pstm.setString(1,NombreCompleto);
            pstm.setString(2,Direccion);
            pstm.setString(3,NumerTelefono);
            pstm.setInt(4, clienteID);
            int rowsAffected = pstm.executeUpdate();//00106423 Ejecutamos la query y guardamos la cantidad de filas que retorna la funcion excuteUpdate

            if (rowsAffected > 0) {//00106423 Si ha modificado mas de 0 filas significa que se ha modificado el cliente correctamente

                ((Stage) btnConfirmar.getScene().getWindow()).close();//00103923 Cierra escena actual
                SceneManager.manageScene(event, "/org/example/parcialfinalpoo/operacion-exitosa.fxml");
                BDConection.closeConnection();//00106423 Cerramos la coneccion despues de modificar el cliente
            } else {
                MostrarError("ERROR AL MODIFICAR CLIENTE", "NO SE ENCONTRÓ NINGÚN CLIENTE CON ESE ID");//00106423 Hacemos uso de la funcion importada MostrarError
            }

        } catch (SQLException e) {
            MostrarError("ERROR AL MODIFICAR", "INTENTA NUEVAMENTE");//00106423 Hacemos uso de la funcion importada MostrarError

        }

    }

    @FXML
    public void btnSalir8OnAction(ActionEvent event) {//00103923 Declara el metodo void btnSalir8OnAction que recibe de parametros un event
        ((Stage)btnSalir8.getScene().getWindow()).close();//00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/menu-empleado.fxml");//00103923 Cambia la escena usando SceneManager
    }

}