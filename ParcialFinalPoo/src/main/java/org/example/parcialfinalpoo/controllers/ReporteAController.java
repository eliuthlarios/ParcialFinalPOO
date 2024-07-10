package org.example.parcialfinalpoo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.parcialfinalpoo.BDConection;
import org.example.parcialfinalpoo.ReporteGenerador;
import org.example.parcialfinalpoo.SceneManager;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReporteAController {

    @FXML//00029223 vinculacion con el archivo fxml
    private DatePicker dpInicio; //00029223 DatePicker de la fecha de inicio

    @FXML//00029223 vinculacion con el archivo fxml
    private DatePicker dpFin; //00029223 DatePicker de la fecha final

    @FXML//00029223 vinculacion con el archivo fxml
    private TextArea txResultado; //00029223 Text Area donde se mostraran los datos

    @FXML//00029223 vinculacion con el archivo fxml
    private Button btnGenerarReporte; //00029223 boton de GenerarReporte

    @FXML//00029223 vinculacion con el archivo fxml
    private Button btnSalir; //00029223 boton Salir

    @FXML//00029223 vinculacion con el archivo fxml
    private TextField idCliente; //00029223 Donde se ingresara el id del cliente


    @FXML
    public void btnSalirAction(ActionEvent event){  //00029223 metodo para salir y cambiar de escena
        ((Stage)btnSalir.getScene().getWindow()).close(); //00029223 Cierra la ventana actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/menu-empleado.fxml"); //00029223 Cambia a la escena del menu empleado
    }


    @FXML
    void generarReporte(ActionEvent event) {//00029223 metodo para generar el reporte
        String id = idCliente.getText(); //00029223 Obtiene el texto del campo de texto idCliente
        LocalDate fechaInicio = dpInicio.getValue(); //00029223 Obtiene la fecha despues de seleccionarla en dpInicio
        LocalDate fechaFin = dpFin.getValue(); //00029223 Obtiene la fecha despues de seleccionarla en dpfin


        if (id != null && !id.trim().isEmpty() && fechaInicio != null && fechaFin != null) {//00029223 Verifica que los campos no se dejen vacios
            try {
                int clienteId = Integer.parseInt(id); //00029223 Convierte el ID del cliente a entero

                Connection connection = BDConection.getConnection(); //00029223 Obtiene la conexión del singleton que se creo de la base de datos
                String query = "{call TransaccionesPorClienteYRangoDeFechas(?, ?, ?)}"; //00029223 llama al procedimiento almacenado, Las ? son los parametros que se mandaran luego
                PreparedStatement statement = connection.prepareStatement(query); //00029223 Prepara el query al procedimiento almacenado
                statement.setInt(1, clienteId); //00029223 Establece el primer parametro de PA
                statement.setDate(2, Date.valueOf(fechaInicio));//00029223 Establece el segundo parametro de PA
                statement.setDate(3, Date.valueOf(fechaFin)); //00029223 //00029223 Establece el tercer parametro de PA

                ResultSet resultSet = statement.executeQuery(); //00029223 Ejecuta la consulta y obtiene el resultado
                List<String> resultados = new ArrayList<>(); //00029223 Crea una lista para almacenar los resultados


                while (resultSet.next()) {//00029223 Itera sobre los resultados de la consulta a la bd
                    resultados.add(resultSet.getString("Transacciones")); //00029223 Añade cada resultado a la lista
                }

                txResultado.setText(String.join("\n", resultados)); //00029223 Muestra los resultados en el TextArea
                ReporteGenerador.generarArchivoReporte("A", resultados); //00029223 manda los parametros a ReporteGenerador para que cree los txt correspondientes

                resultSet.close(); //00029223 Cierra el ResultSet
                statement.close(); //00029223 Cierra el PreparedStatement
                BDConection.closeConnection(); //00029223 Cierra la conexión a la base de datos del singleton
            } catch (NumberFormatException e) { //00029223 Captura la excepcion si ingresa mal el id del cliente
                txResultado.setText("El ID del cliente debe ser un numero"); //00029223 manda un mensaje de error en el TextArea
            } catch (SQLException e) { //00029223 captura la excepcion si algo sale mal en la base da datos
                e.printStackTrace(); //00029223 Imprime la excepcion
                txResultado.setText("Error en la base de datos."); //00029223 manda un mensaje de error en el TextArea
            }
        } else {
            txResultado.setText("No deje campos vacios"); //00029223 manda un mensaje si los campos no están completos en el TextArea
        }
    }
}
