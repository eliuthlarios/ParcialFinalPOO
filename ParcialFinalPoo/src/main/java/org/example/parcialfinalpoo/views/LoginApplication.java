package org.example.parcialfinalpoo.views;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/parcialfinalpoo/login.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 854, 480);
            stage.setTitle("BCN");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
            System.out.println("Aplicacion iniciada");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al iniciar la aplicacion");
        }
    }

    public static void main(String[] args) {
        launch();
    }
}