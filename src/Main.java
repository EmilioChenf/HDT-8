import javafx.application.Application;
import view.EmergencyUI;

/**
 * Clase principal del sistema de emergencias.
 * Lanza la aplicación JavaFX que permite gestionar pacientes en la sala de emergencia.
 * 
 * @author Fátima Navarro
 * @author Emilio Chen
 */
public class Main {

    /**
     * Método principal que lanza la aplicación JavaFX.
     *
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        Application.launch(EmergencyUI.class, args);
    }
}
