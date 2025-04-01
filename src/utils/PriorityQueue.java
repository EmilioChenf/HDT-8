package utils;

/**
 * Interfaz genérica para una cola de prioridad.
 * Define las operaciones básicas que una estructura de datos
 * tipo PriorityQueue debe implementar.
 *
 * @param <E> Tipo de elementos almacenados, deben ser comparables entre sí.
 * 
 * @author Fátima Navarro
 * @author Emilio Chen
 */
public interface PriorityQueue<E extends Comparable<E>> {

    /**
     * Agrega un nuevo elemento a la cola de prioridad.
     *
     * @param value El elemento a agregar.
     */
    void add(E value);

    /**
     * Elimina y retorna el elemento con mayor prioridad de la cola.
     *
     * @return El elemento con mayor prioridad, o null si la cola está vacía.
     */
    E remove();

    /**
     * Retorna el elemento con mayor prioridad sin eliminarlo.
     *
     * @return El elemento con mayor prioridad, o null si la cola está vacía.
     */
    E peek();

    /**
     * Verifica si la cola de prioridad está vacía.
     *
     * @return true si está vacía, false en caso contrario.
     */
    boolean isEmpty();
}
