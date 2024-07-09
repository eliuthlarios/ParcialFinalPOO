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

public class AgregarClienteController {//00103923 Declara la clase AgregarClienteController
    @FXML
    private TextField txtFieldNombreCliente2;//00103923 Declara el text field btnSalir10
    @FXML
    private TextArea txtAreaDireccion1;//00103923 Declara el text field btnSalir10
    @FXML
    private TextField txtFieldTelefono1;//00103923 Declara el text field btnSalir10
    @FXML
    private Button btnAgregar1;//00103923 Declara el boton btnSalir10
    @FXML
    private Button btnSalir6;//00103923 Declara el boton btnSalir10

    @FXML
    public void agregarOnAction(ActionEvent event) throws SQLException {//00103923 Declara el metodo void agregarOnAction que recibe de parametros un event

        String nombreCompleto = txtFieldNombreCliente2.getText();//00106423 Guardamos en una variable el valor del textField que recibe el nombre completo del usuario
        String direccion = txtAreaDireccion1.getText();//00106423 Guardamos en una variable el valor del textField que recibe la direccion del usuario
        String numeroTelefono = txtFieldTelefono1.getText();//00106423 Guardamos en una variable el valor del textField que recibe el numero de telefono del usuario

        if (nombreCompleto.isEmpty() || direccion.isEmpty() || numeroTelefono.isEmpty()) {//00106423 Hacemos un if para verificar que se han rellenado todos los datos solicitados
            MostrarError("ERROR AL AGREGAR CLIENTE", "RELLENA LOS CAMPOS SOLICITADOS");//00106423 Hacemos uso de la funcion importada MostrarError
            return;//00106423 Salimos del metodo
        }

        String SQL_query = "INSERT INTO Clientes(NombreCompleto, Direccion, NumeroTelefono) VALUES(?, ?, ?)";//00106423 Escribimos la query que agregara los clientes a la BD

        try (Connection conn = BDConection.getConnection();//00106423 En un bloque try-catch manipulamos la BD y abrimos la coneccion
             PreparedStatement pstm = conn.prepareStatement(SQL_query)) {//00106423 Le pasamos la query

            //00106423 Agregamos los datos escritos por el usuario en los text labels a la query
            pstm.setString(1, nombreCompleto);
            pstm.setString(2, direccion);
            pstm.setString(3, numeroTelefono);
            pstm.executeUpdate();//00106423 Ejecutamos la query

            ((Stage) btnAgregar1.getScene().getWindow()).close();//00103923 Cierra escena actual
            SceneManager.manageScene(event, "/org/example/parcialfinalpoo/operacion-exitosa.fxml");

        } catch (SQLException e) {//00106423 Notificamos al usuario de posibles errores
            MostrarError("ERROR AL AGREGAR CLIENTE", "INTENTA NUEVAMENTE");
        } finally {
            BDConection.closeConnection();//00106423 Cerramos la coneccion despues de Agregar el cliente
        }

    }
    @FXML
    public void btnSalir6OnAction(ActionEvent event) {//00103923 Declara el metodo void btnSalir6OnAction que recibe de parametros un event
        ((Stage)btnSalir6.getScene().getWindow()).close();//00103923 Cierra escena actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/menu-empleado.fxml");//00103923 Cambia la escena usando SceneManager
    }

}
