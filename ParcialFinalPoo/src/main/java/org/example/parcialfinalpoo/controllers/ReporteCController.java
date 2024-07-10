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

public class ReporteCController {

    @FXML //00029223 vinculacion al fxml
    private TextField idCliente; //00029223 TextField del id del cliente

    @FXML//00029223 vinculacion al fxml
    private TextArea txResultado;//00029223 TextArea del resultado

    @FXML//00029223 vinculacion al fxml
    private Button buttonGenerarReporte;//00029223 boton de generar reporte

    @FXML//00029223 vinculacion al fxml
    private Button btnSalir;//00029223 boton de Salir


    @FXML
    public void btnSalirAction(ActionEvent event) {//00029223 metodo para salir y cambiar de escena
        ((Stage) btnSalir.getScene().getWindow()).close(); //00029223 cierra la ventana actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/menu-empleado.fxml"); //00029223 Cambia a la escena del menu empleado
    }


    @FXML
    void generarReporte(ActionEvent event) { //00029223 metodo para generar el reporte
        String id = idCliente.getText(); //00029223 Obtiene el texto del campo del id


        if (id != null && !id.trim().isEmpty()) { //00029223 Verifica que el campo no este vacio
            try {
                int clienteId = Integer.parseInt(id); //00029223 Convierte el ID del cliente a int

                Connection connection = BDConection.getConnection(); //00029223 Obtiene la conexion del sigleton de la base de datos
                String query = "{call ListarTarjetasPorCliente(?)}"; //00029223 Llada al PA de la base de datos, solo recibira un parametro
                PreparedStatement statement = connection.prepareStatement(query); //00029223 prepara la llamada de PA
                statement.setInt(1, clienteId); //00029223 Establece el primer parametro

                ResultSet resultSet = statement.executeQuery(); //00029223 Ejecuta la consulta y obtiene el resultado
                List<String> resultados = new ArrayList<>(); //00029223 Crea una lista para almacenar los resultados


                while (resultSet.next()) { //00029223 Itera sobre los resultados que de la consulta
                    resultados.add(resultSet.getString("DetalleTarjeta")); //00029223 anade el resultado a la lista
                }

                txResultado.setText(String.join("\n", resultados)); //00029223 Muestra los resultados en el TextArea
                ReporteGenerador.generarArchivoReporte("C", resultados); //00029223 manda parametros al generador de txts

                resultSet.close(); //00029223 Cierra el ResultSet
                statement.close(); //00029223 Cierra el statement del el llamado al PA
                BDConection.closeConnection(); //00029223 Cierra la conexiopn del singleton de la base de datos
            } catch (NumberFormatException e) { //00029223 Captura la excepcion si escribe mal el id
                txResultado.setText("El ID del cliente debe ser un numero."); //00029223 manda un mensaje de error en el TextArea
            } catch (SQLException e) { //00029223 Captura la excepcion si algo sale mal en la base de datos
                e.printStackTrace(); //00029223 Imprime la excepcion
                txResultado.setText("Error en la base de datos."); //00029223 manda un mensaje de error en el TextArea
            }
        } else {
            txResultado.setText("No deje el id del cliente vacio."); //00029223 manda un mensaje si el campo ID del Cliente esta vacio
        }
    }
}
