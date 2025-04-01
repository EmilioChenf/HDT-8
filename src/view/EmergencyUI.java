package view;

import controller.EmergencyController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.Paciente;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Clase que representa la interfaz gráfica del sistema de emergencias.
 * Permite cargar pacientes desde archivo, agregar nuevos pacientes manualmente
 * y atender pacientes por orden de prioridad.
 * 
 * Utiliza JavaFX para crear la ventana interactiva del sistema.
 * 
 * @author Fátima Navarro
 * @author Emilio Chen
 */
public class EmergencyUI extends Application {

    private EmergencyController controller;
    private TextArea logArea;

    /**
     * Método principal que construye la interfaz gráfica.
     * Crea campos de entrada, botones de acción y el área de log.
     * Asocia eventos para agregar, cargar y atender pacientes.
     *
     * @param primaryStage La ventana principal de la aplicación JavaFX.
     */
    @Override
    public void start(Stage primaryStage) {
        controller = new EmergencyController();

        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        // Campos de entrada para nuevo paciente
        TextField nombreField = new TextField();
        nombreField.setPromptText("Nombre del paciente");

        TextField sintomaField = new TextField();
        sintomaField.setPromptText("Síntoma");

        ComboBox<String> prioridadBox = new ComboBox<>();
        prioridadBox.getItems().addAll("A", "B", "C", "D", "E");
        prioridadBox.setPromptText("Prioridad");

        Button agregarButton = new Button("Agregar paciente");
        Button loadButton = new Button("Cargar pacientes");
        Button nextButton = new Button("Atender siguiente");

        logArea = new TextArea();
        logArea.setEditable(false);
        logArea.setPrefHeight(300);

        // Acción para agregar paciente
        agregarButton.setOnAction(e -> {
            String nombre = nombreField.getText().trim();
            String sintoma = sintomaField.getText().trim();
            String prioridad = prioridadBox.getValue();

            if (!nombre.isEmpty() && !sintoma.isEmpty() && prioridad != null) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("pacientes.txt", true))) {
                    writer.write(nombre + "," + sintoma + "," + prioridad);
                    writer.newLine();
                    logArea.appendText("Paciente agregado: " + nombre + " - " + sintoma + " - " + prioridad + "\n");

                    // Recargar pacientes automáticamente
                    controller.loadPacientes("pacientes.txt");

                    // Limpiar campos
                    nombreField.clear();
                    sintomaField.clear();
                    prioridadBox.setValue(null);
                } catch (IOException ex) {
                    ex.printStackTrace();
                    logArea.appendText("Error al guardar el paciente\n");
                }
            } else {
                logArea.appendText("Debes completar todos los campos para agregar un paciente.\n");
            }
        });

        // Acción para cargar pacientes
        loadButton.setOnAction(e -> {
            controller.loadPacientes("pacientes.txt");
            logArea.appendText("Pacientes cargados.\n");
        });

        // Acción para atender siguiente paciente
        nextButton.setOnAction(e -> {
            Paciente p = controller.atenderPaciente();
            if (p != null) {
                logArea.appendText("Atendiendo a: " + p + "\n");
            } else {
                logArea.appendText("No hay más pacientes.\n");
            }
        });

        // Agregar componentes a la interfaz
        root.getChildren().addAll(
            new Label("Agregar nuevo paciente:"),
            nombreField,
            sintomaField,
            prioridadBox,
            agregarButton,
            new Separator(),
            loadButton,
            nextButton,
            logArea
        );

        Scene scene = new Scene(root, 500, 500);
        primaryStage.setTitle("Sistema de Emergencias");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
