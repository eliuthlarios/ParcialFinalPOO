package org.example.parcialfinalpoo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.parcialfinalpoo.BDConection;
import org.example.parcialfinalpoo.ReporteGenerador;
import org.example.parcialfinalpoo.SceneManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReporteBController { //00029223 Define la clase pública ReporteBController

    @FXML //00029223 vinculacion con el archivo fxml
    private TextField idCliente; //00029223 TextField del id del cliente

    @FXML //00029223 vinculacion con el archivo fxml
    private TextField mes; //00029223 TextField del mes

    @FXML //00029223 vinculacion con el archivo fxml
    private TextField anio; //00029223 TextField anio

    @FXML //00029223 vinculacion con el archivo fxml
    private TextArea txResultado; //00029223 TextArea del Resultado

    @FXML //00029223 vinculacion con el archivo fxml
    private Button buttonGenerarReporte; //00029223 Declara el boton para Generar Reporte

    @FXML //00029223 vinculacion con el archivo fxml
    private Button btnSalir; //00029223 Declara el boton de Salir


    @FXML
    public void btnSalirAction(ActionEvent event) {//00029223 metodo para salir y cambiar de escena
        ((Stage) btnSalir.getScene().getWindow()).close(); //00029223 Cierra la ventana actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/menu-empleado.fxml"); //00029223 Cambia a la escena menu empleado
    }


    @FXML
    void generarReporte(ActionEvent event) { //00029223 metodo para generar el reporte
        String id = idCliente.getText(); //00029223 Obtiene el id del campo
        String mesStr = mes.getText(); //00029223 Obtiene el mes del campo
        String anoStr = anio.getText(); //00029223 Obtiene el anio del campo


        if (id != null && !id.trim().isEmpty() && mesStr != null && !mesStr.trim().isEmpty() && anoStr != null && !anoStr.trim().isEmpty()) { //00029223 Verifica que los campos no esten vacíos
            try {
                int clienteId = Integer.parseInt(id); //00029223 Convierte el ID del cliente a int
                int mes = Integer.parseInt(mesStr); //00029223 Convierte el mes a int
                int anio = Integer.parseInt(anoStr); //00029223 Convierte el año a int

                Connection connection = BDConection.getConnection(); //00029223 Obtiene la conexion del singleton del base de datos
                String query = "SELECT dbo.TotalGastadoPorClienteEnMes(?, ?, ?)"; //00029223 llama a la funcion creada en la base de datos
                PreparedStatement statement = connection.prepareStatement(query); //00029223 Prepara la llamada a la funcion
                statement.setInt(1, clienteId); //00029223 Establece el primer parametro, el id
                statement.setInt(2, mes); //00029223 Establece el segundo parametro, el mes
                statement.setInt(3, anio); //00029223 Establece el tercer paramatro, el anio

                ResultSet resultSet = statement.executeQuery(); //00029223 Ejecuta la consulta y obtiene el resultado
                List<String> resultados = new ArrayList<>(); //00029223 Crea una lista para almacenar los resultados


                if (resultSet.next()) {//00029223 Verifica si aun faltan lineas en el resutado
                    resultados.add("Total Gastado: " + resultSet.getBigDecimal(1)); //00029223 anade el resultado a la lista
                }

                txResultado.setText(String.join("\n", resultados)); //00029223 Muestra los resultados en el TextArea

                ReporteGenerador.generarArchivoReporte("B", resultados); //00029223 manda los parametros al generador de archivos, para que genere el correspondiente txt


                resultSet.close(); //00029223 Cierra el ResultSet
                statement.close(); //00029223 Cierra el statement de la funcion
                BDConection.closeConnection(); //00029223 Cierra la conexion a la base de datos usando el metodo del singleton de la bd
            } catch (NumberFormatException e) { //00029223 captura la excepcion si pone mal el id
                txResultado.setText("El ID del cliente, el mes y el año deben ser números enteros."); //00029223 manda un mensaje de error en el TextArea
            } catch (SQLException e) { //00029223 captura la excepcion si algo ocurre sale mal en la bd
                e.printStackTrace(); //00029223 Imprime la excepcion
                txResultado.setText("Error al consultar la base de datos."); //00029223 manda un mensaje de error en el TextArea
            }
        } else {
            txResultado.setText("Por favor, complete todos los campos."); //00029223 manda un mensaje si los campos no estan completos
        }
    }
}
