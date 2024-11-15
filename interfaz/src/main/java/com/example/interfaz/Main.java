package com.example.interfaz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        // Cargar el archivo FXML del Menú principal
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/interfaz/MainView.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Menú Principal");

        // Configurar el ícono de la ventana
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/interfaz/icono.png")));
        primaryStage.getIcons().add(icon);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
