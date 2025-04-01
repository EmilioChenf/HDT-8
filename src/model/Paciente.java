package model;

/**
 * Representa la ficha médica de un paciente en el sistema de emergencias.
 * Cada paciente tiene un nombre, un síntoma y un código de prioridad.
 * Implementa la interfaz Comparable para ser ordenado en una cola de prioridad.
 * 
 * La prioridad es determinada por el código de emergencia (A–E), donde
 * 'A' representa la mayor urgencia y 'E' la menor.
 * 
 * @author Fátima Navarro
 * @author Emilio Chen
 */
public class Paciente implements Comparable<Paciente> {

    private String nombre;
    private String sintoma;
    private char codigo;

    /**
     * Constructor para inicializar un nuevo paciente.
     *
     * @param nombre Nombre del paciente.
     * @param sintoma Síntoma principal que presenta el paciente.
     * @param codigo Código de emergencia (letra de la A a la E).
     */
    public Paciente(String nombre, String sintoma, char codigo) {
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.codigo = codigo;
    }

    /**
     * Obtiene el nombre del paciente.
     *
     * @return Nombre del paciente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el síntoma del paciente.
     *
     * @return Descripción del síntoma.
     */
    public String getSintoma() {
        return sintoma;
    }

    /**
     * Obtiene el código de emergencia del paciente.
     *
     * @return Código de prioridad (A–E).
     */
    public char getCodigo() {
        return codigo;
    }

    /**
     * Compara a este paciente con otro según el código de emergencia.
     * Un código menor (más cercano a 'A') tiene mayor prioridad.
     *
     * @param otro Otro paciente a comparar.
     * @return Valor negativo si este paciente tiene mayor prioridad,
     *         cero si tienen la misma prioridad,
     *         o positivo si el otro tiene mayor prioridad.
     */
    @Override
    public int compareTo(Paciente otro) {
        return Character.compare(this.codigo, otro.codigo);
    }

    /**
     * Retorna una representación en texto del paciente.
     *
     * @return Cadena con nombre, síntoma y prioridad.
     */
    @Override
    public String toString() {
        return nombre + " - " + sintoma + " - Prioridad: " + codigo;
    }
}
