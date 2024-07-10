package org.example.parcialfinalpoo;

import javafx.scene.control.Alert;

public abstract class AlertControllers {////00106423 Esta clase contendra una funcion que mostrara las ventana de errores
    public static void MostrarError(String encabezado, String contenido) {//00106423 Le pasamos el encabezado del error y el contenido
        Alert error = new Alert(Alert.AlertType.ERROR);//00106423 Instanciamos un objeto de tipo alert errror
        error.setTitle("ERROR");//00106423 Seteamos el titulo de la ventana
        error.setHeaderText(encabezado);//00106423 Seteamos el encabezado
        error.setContentText(contenido);//00106423 Seteamos el contenido
        error.showAndWait();//00106423 mostramos la ventana y esperamos a que el usuario cierre dicha ventana
    }
}
