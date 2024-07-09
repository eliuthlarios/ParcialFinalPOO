package org.example.parcialfinalpoo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.parcialfinalpoo.BDConection;
import org.example.parcialfinalpoo.SceneManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class AgregarClienteController {
    @FXML
    private TextField txtFieldNombreCliente2;
    @FXML
    private TextArea txtAreaDireccion1;
    @FXML
    private TextField txtFieldTelefono1;
    @FXML
    private Button btnAgregar1;
    @FXML
    private Button btnSalir6;
    private Alert error=new Alert(Alert.AlertType.ERROR);//00106423 Creamos un objeto Alert para mostrar posible errores

    @FXML
    public void agregarOnAction(ActionEvent event) {

        String SQL_query="insert into Clientes(NombreCompleto,Direccion,NumeroTelefono) values(?,?,?)";//00106423 Escribimos la query que agregara los clientes a la BD
        String NombreCompleto=txtFieldNombreCliente2.getText();//00106423 Guardamos en una variable el valor del textField que recibe el nombre completo del usuario
        String Direccion=txtAreaDireccion1.getText();//00106423 Guardamos en una variable el valor del textField que recibe la direccion del usuario
        String NumeroTelefono=txtFieldTelefono1.getText();//00106423 Guardamos en una variable el valor del textField que recibe el numero de telefono del usuario

        try{//00106423 Hacemos las manipulaciones de la BD dentro de un bloque try-catch
            Connection conn= BDConection.getConnection();//00106423 Establecemos coneccion con la BD
            PreparedStatement pstm=conn.prepareStatement(SQL_query);//00106423 Preparamos la query
            pstm.setString(1,NombreCompleto);//00106423 Establecemos el valor del nombre completo con el valor que capturamos del text field
            pstm.setString(2,Direccion);//00106423 Establecemos el valor de la dirrecion con el valor que capturamos del text field
            pstm.setString(3,NumeroTelefono);//00106423 Establecemos el valor del numero de telefono con el valor que capturamos del text field
            pstm.executeUpdate();//00106423 Ejecutamos la query

            if(NombreCompleto.isEmpty() || Direccion.isEmpty() || NumeroTelefono.isEmpty() ) {//00106423 Iniciamos un if para verificar que el usuario efectivamente digito datos
                error.setTitle("ERROR");
                error.setHeaderText("ERROR AL AGREGAR CLIENTE");
                error.setContentText("VERIFICA QUE LOS DATOS AGREGADOS SEAN VALIDOS");
                error.showAndWait();
            }
            else{//00106423 Mostramos la ventana de exito si el cliente se agrego correctamente a la BD
                ((Stage)btnAgregar1.getScene().getWindow()).close(); //00103923 Cierra escena actual
                SceneManager.manageScene(event, "/org/example/parcialfinalpoo/operacion-exitosa.fxml");

            }
        } catch (SQLException e) {//00106423 Si algo falla durante la ejecucion lanzamos una excepcion con el catch
            throw new RuntimeException(e);
        }

    }
    @FXML
    public void btnSalir6OnAction(ActionEvent event) {
        ((Stage)btnSalir6.getScene().getWindow()).close();
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/menu-empleado.fxml");
    }
}
