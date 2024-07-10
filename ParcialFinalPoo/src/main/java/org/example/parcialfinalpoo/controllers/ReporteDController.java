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

public class ReporteDController { //00029223 Define la clase pública ReporteDController

    @FXML //00029223 vincula con el fxml
    private TextField facilitador; //00029223 TextField del facilitador

    @FXML //00029223 vincula con el fxml
    private TextArea txResultado; //00029223 TextArea del Resultado

    @FXML //00029223 vincula con el fxml
    private Button buttonGenerarReporte; //00029223 boton buttonGenerarReporte

    @FXML //00029223 vincula con el fxml
    private Button btnSalir; //00029223 boton para Salir

    @FXML
    public void btnSalirAction(ActionEvent event) {//00029223 metodo para cambiar de escena y cerrar la actual
        ((Stage) btnSalir.getScene().getWindow()).close(); //00029223 Cierra la ventana actual
        SceneManager.manageScene(event, "/org/example/parcialfinalpoo/menu-empleado.fxml"); //00029223 Cambia a la escena a la de menu empleado
    }


    @FXML
    void generarReporte(ActionEvent event) {    //00029223 metodo para generar el reporte
        String facilitadorInput = facilitador.getText(); //00029223 Obtiene el texto del campo del facilitador


        if (facilitadorInput != null && !facilitadorInput.trim().isEmpty()) { //00029223 Verifica que el campo no este vacio
            try {
                Connection connection = BDConection.getConnection(); //00029223 Obtiene la conexion del singleton de la base de datos
                String query = "{call ReportePorFacilitador(?)}"; //00029223 llama a procedimiento almacenad, recibira un parametro
                PreparedStatement statement = connection.prepareStatement(query); //00029223 Prepara la llamada al procedimiento almacenado
                statement.setString(1, facilitadorInput); //00029223 Establece el facilitador

                ResultSet resultSet = statement.executeQuery(); //00029223 Ejecuta la consulta y obtiene el resultado
                List<String> resultados = new ArrayList<>(); //00029223 Crea una lista para almacenar los resultados


                while (resultSet.next()) {//00029223 Itera sobre los resultados de la consulta, evalua si aun faltan
                    resultados.add(resultSet.getString("Reporte")); //00029223 anade cada resultado a la lista
                }

                txResultado.setText(String.join("\n", resultados)); //00029223 Muestra el resultado en el TextArea
                ReporteGenerador.generarArchivoReporte("D", resultados); //00029223 manda los parametros al generador de txts

                resultSet.close(); //00029223 Cierra el ResultSet
                statement.close(); //00029223 Cierra el statement de la llamada
                BDConection.closeConnection(); //00029223 Cierra la conexion del singleton de la base de datos
            } catch (SQLException e) { //00029223 Captura la excepcion si algo sale mal en la base de datos
                e.printStackTrace(); //00029223 Imprime la excepcion
                txResultado.setText("Error al consultar la base de datos."); //00029223 manda un mensaje de error en el TextArea
            }
        } else {
            txResultado.setText("No deje el campo vacio."); //00029223 manda un mensaje si el campo Facilitador está vacío
        }
    }
}
