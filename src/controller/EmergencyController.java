package controller;

import model.Paciente;
import utils.VectorHeap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EmergencyController {
    private VectorHeap<Paciente> heap = new VectorHeap<>();

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

    public Paciente atenderPaciente() {
        return heap.remove();
    }
}
