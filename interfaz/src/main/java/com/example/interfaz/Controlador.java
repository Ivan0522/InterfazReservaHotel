package com.example.interfaz;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class Controlador {

    // Datos del cliente
    @FXML private TextField campoDNI;
    @FXML private TextField campoNombre;
    @FXML private TextField campoDireccion;
    @FXML private TextField campoLocalidad;
    @FXML private TextField campoProvincia;

    // Datos de la reserva
    @FXML private DatePicker fechaLlegada;
    @FXML private DatePicker fechaSalida;
    @FXML private Spinner<Integer> numeroPersonas;
    @FXML private ComboBox<String> tipoHabitacion;
    @FXML private CheckBox esFumador;

    // Régimen de alojamiento
    @FXML private RadioButton desayunoRadio;
    @FXML private RadioButton mediaPensionRadio;
    @FXML private RadioButton pensionCompletaRadio;
    @FXML private Label advertenciaFumador;

    private ToggleGroup grupoRegimen;

    // Botones de acción
    @FXML private Button btnVolver;
    @FXML private Button btnLimpiar;
    @FXML private Button btnAceptar;
    @FXML private Button btnCancelar;

    // Declaración de etiquetas
    @FXML private Label labelDNI;
    @FXML private Label labelNombre;
    @FXML private Label labelDireccion;
    @FXML private Label labelLocalidad;
    @FXML private Label labelProvincia;
    @FXML private Label labelFechaLlegada;
    @FXML private Label labelFechaSalida;
    @FXML private Label labelNPersonas;
    @FXML private Label labelHabitacion;

    @FXML
    public void initialize() {
        // Asociar etiquetas con sus campos de texto correspondientes
        labelDNI.setLabelFor(campoDNI);
        labelNombre.setLabelFor(campoNombre);
        labelDireccion.setLabelFor(campoDireccion);
        labelLocalidad.setLabelFor(campoLocalidad);
        labelProvincia.setLabelFor(campoProvincia);
        labelFechaLlegada.setLabelFor(fechaLlegada);
        labelFechaSalida.setLabelFor(fechaSalida);
        labelNPersonas.setLabelFor(numeroPersonas);
        labelHabitacion.setLabelFor(tipoHabitacion);

        // Inicializar el ToggleGroup para los regímenes de alojamiento
        grupoRegimen = new ToggleGroup();
        desayunoRadio.setToggleGroup(grupoRegimen);
        mediaPensionRadio.setToggleGroup(grupoRegimen);
        pensionCompletaRadio.setToggleGroup(grupoRegimen);

        // Configuración inicial del Spinner de número de personas (Min 1persona, Max 10personas)
        numeroPersonas.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1));

        // Listener para mostrar u ocultar la advertencia para fumadores
        esFumador.selectedProperty().addListener((observable, oldValue, newValue) -> {
            advertenciaFumador.setVisible(newValue);
        });

        // Añadir Tooltips a cada componente
        campoDNI.setTooltip(new Tooltip("Introduzca el DNI del cliente."));
        campoNombre.setTooltip(new Tooltip("Introduzca el nombre completo del cliente."));
        campoDireccion.setTooltip(new Tooltip("Introduzca la dirección del cliente."));
        campoLocalidad.setTooltip(new Tooltip("Introduzca la localidad del cliente."));
        campoProvincia.setTooltip(new Tooltip("Introduzca la provincia del cliente."));
        fechaLlegada.setTooltip(new Tooltip("Seleccione la fecha de llegada al hotel."));
        fechaSalida.setTooltip(new Tooltip("Seleccione la fecha de salida del hotel."));
        numeroPersonas.setTooltip(new Tooltip("Seleccione el número de personas que se alojarán."));
        tipoHabitacion.setTooltip(new Tooltip("Seleccione el tipo de habitación deseado."));
        esFumador.setTooltip(new Tooltip("Marque si la habitación es para fumador."));
        desayunoRadio.setTooltip(new Tooltip("Régimen de alojamiento: Alojamiento y desayuno."));
        mediaPensionRadio.setTooltip(new Tooltip("Régimen de alojamiento: Media pensión."));
        pensionCompletaRadio.setTooltip(new Tooltip("Régimen de alojamiento: Pensión completa."));
        advertenciaFumador.setTooltip(new Tooltip("Aviso: Solo se permite fumar en habitaciones designadas para fumadores."));
        btnLimpiar.setTooltip(new Tooltip("Limpia todos los campos del formulario."));
        btnAceptar.setTooltip(new Tooltip("Acepta y guarda la reserva."));
        btnCancelar.setTooltip(new Tooltip("Cancela la reserva actual."));
    }

    @FXML
    private void limpiarFormulario() {
        // Limpiar todos los campos
        campoDNI.clear();
        campoNombre.clear();
        campoDireccion.clear();
        campoLocalidad.clear();
        campoProvincia.clear();
        fechaLlegada.setValue(null);
        fechaSalida.setValue(null);
        numeroPersonas.getValueFactory().setValue(1);
        tipoHabitacion.getSelectionModel().selectFirst();
        esFumador.setSelected(false);
        grupoRegimen.selectToggle(null);
        advertenciaFumador.setVisible(false);
    }

    @FXML
    private void procesarReserva() {
        // Recoger datos del formulario
        String dni = campoDNI.getText();
        String nombre = campoNombre.getText();
        String direccion = campoDireccion.getText();
        String localidad = campoLocalidad.getText();
        String provincia = campoProvincia.getText();
        String fechaLlegadaTexto = fechaLlegada.getValue() != null ? fechaLlegada.getValue().toString() : "";
        String fechaSalidaTexto = fechaSalida.getValue() != null ? fechaSalida.getValue().toString() : "";
        int numPersonas = numeroPersonas.getValue();
        String tipoDeHabitacion = tipoHabitacion.getValue();
        String regimen = grupoRegimen.getSelectedToggle() != null ? ((RadioButton) grupoRegimen.getSelectedToggle()).getText() : "No especificado";

        // Mostrar detalles de la reserva
        System.out.println("Reserva realizada:\nDNI: " + dni +
                "\n>> Nombre: " + nombre +
                "\n>> Dirección: " + direccion +
                "\n>> Localidad: " + localidad +
                "\n>> Provincia: " + provincia +
                "\n>> Fecha de llegada: " + fechaLlegadaTexto +
                "\n>> Fecha de salida: " + fechaSalidaTexto +
                "\nNúmero de personas: " + numPersonas +
                "\nTipo de habitación: " + tipoDeHabitacion +
                "\nRégimen: " + regimen);
    }

    @FXML
    private void cancelarReserva() {
        System.out.println("--------------------------------- Reserva cancelada ---------------------------------");
    }

    @FXML
    private void volverAlMenu() {
        // Cerrar la ventana de reserva y volver al menú principal
        Stage stage = (Stage) btnVolver.getScene().getWindow();
        stage.close();
    }
}
