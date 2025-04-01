package controller;

import model.Paciente;
import utils.VectorHeap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Controlador principal del sistema de emergencias.
 * Gestiona la carga de pacientes desde un archivo y la atención
 * en orden de prioridad utilizando un VectorHeap como cola de prioridad.
 *
 * @author Fátima Navarro
 * @author Emilio Chen
 */
public class EmergencyController {

    /** Cola de prioridad basada en heap para manejar los pacientes. */
    private VectorHeap<Paciente> heap = new VectorHeap<>();

    /**
     * Carga los pacientes desde un archivo de texto con formato CSV.
     * Cada línea del archivo debe tener el siguiente formato:
     * Nombre, Síntoma, Código
     * Se agregan a la cola de prioridad según su código de emergencia.
     *
     * @param archivo Nombre del archivo de texto a leer (por ejemplo, "pacientes.txt").
     */
    public void loadPacientes(String archivo) {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 3) {
                    String nombre = partes[0].trim();
                    String sintoma = partes[1].trim();
                    char codigo = partes[2].trim().charAt(0);
                    Paciente p = new Paciente(nombre, sintoma, codigo);
                    heap.add(p);
                    count++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Pacientes cargados: " + count);
    }

    /**
     * Atiende al siguiente paciente en la cola de prioridad.
     *
     * @return El paciente con mayor prioridad, o null si la cola está vacía.
     */
    public Paciente atenderPaciente() {
        return heap.remove();
    }
}
