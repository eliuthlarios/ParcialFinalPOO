package org.example.parcialfinalpoo.views;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class LoginApplication extends Application { //00103923 Declara la clase LoginApplication la cual extiende de Application
    @Override
    public void start(Stage stage) throws IOException { //00103923 Sobreescribe el metodo start el cual tiene de parametro un stage y puede lanzar una IOException
        try { //00103923 Inicio del try
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/parcialfinalpoo/login.fxml")); //00103923 Carga el archivo fxml
            Scene scene = new Scene(fxmlLoader.load(), 854, 480); //Crea una nueva escena con el contenido del fxml y el tamaño proporcionado
            stage.setTitle("BCN"); //00103923 Establece el título de la ventana
            stage.setResizable(false); //00103923 Establece que la ventana no se pueda redimensionar
            stage.setScene(scene); //00103923 Establece la escena en el stage
            stage.show(); //00103923 Muestra la escena
            System.out.println("Aplicacion iniciada"); //00103923 Muestra un mensaje de que la aplicacion se inició correctamente
        } catch (IOException e) { //00103923 Captura cualquier IOException que ocurra
            e.printStackTrace(); //00103923 Muestra el seguimiento del error
            System.out.println("Error al iniciar la aplicacion"); //00103923 Muestra un mensaje de error
        }
    }

    public static void main(String[] args) { //00103923 Declara el metodo main
        launch(); //00103923 Lanza la aplicacion
    }
}