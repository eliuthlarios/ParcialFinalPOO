package org.example.parcialfinalpoo;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class SceneManager { //00103923 Declara la clase SceneManager
    private String url; //00103923 Declara una variable del tipo String llamada url

    public static void manageScene(ActionEvent event, String url){ //00103923 Declara un metodo estatico llamado manageScene
        try { //00103923 Inicio del try
            FXMLLoader fxmlLoader = new FXMLLoader(SceneManager.class.getResource(url)); //00103923 Cargar el archivo FXML que se usa en la nueva escena
            Parent root = fxmlLoader.load(); //00103923 Cargar el contenido
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //00103923 Obtener la instancia del Stage desde el evento
            Scene scene = new Scene(root); //00103923 Crear una nueva escena con el contenido cargado
            stage.setResizable(false); //00103923 Evita que el stage sea redimensionable
            stage.setScene(scene); //00103923 Establece la nueva escena
            stage.show(); //00103923 Muestra la nueva escena

        } catch (IOException e){ //00103923 Inicio del catch
            e.printStackTrace(); //00103923 Imprime el error en caso de excepcion
            System.out.println("Failed to load escene");//00103923 Imprime un mensaje en consola
        }
    }
}
