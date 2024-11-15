package com.example.interfaz;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.IOException;
import java.util.Objects;

public class ReservaHotel {

    @FXML
    private Button btnSalirAplicacion;

    @FXML
    private void abrirReservas() {
        try {
            // Cargar el archivo FXML de la vista de reservas
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/interfaz/hello-view.fxml"));
            Parent root = loader.load();

            // Crear una nueva ventana para la vista de reservas
            Stage reservaStage = new Stage();
            reservaStage.setTitle("Reservas");

            // Configurar el ícono de la ventana
            Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/interfaz/icono.png")));
            reservaStage.getIcons().add(icon);

            reservaStage.setScene(new Scene(root));
            reservaStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void salirAplicacion() {
        // Cerrar la aplicación
        Stage stage = (Stage) btnSalirAplicacion.getScene().getWindow();
        stage.close();
    }
}
