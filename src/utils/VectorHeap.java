package utils;

import java.util.ArrayList;

/**
 * Implementación de una cola de prioridad (PriorityQueue)
 * utilizando un heap binario (min-heap) respaldado por un ArrayList.
 * 
 * Los elementos de menor valor (según su comparación) tienen mayor prioridad.
 *
 * @param <E> Tipo de datos que extiende Comparable.
 * 
 * @author Fátima Navarro
 * @author Emilio Chen
 */
public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {

    /** Lista que contiene los elementos del heap. */
    protected ArrayList<E> data;

    /**
     * Constructor que inicializa el heap como una lista vacía.
     */
    public VectorHeap() {
        data = new ArrayList<>();
    }

    /**
     * Agrega un nuevo elemento al heap y reordena con percolación hacia arriba.
     *
     * @param value Elemento a insertar.
     */
    @Override
    public void add(E value) {
        data.add(value);
        percolateUp(data.size() - 1);
    }

    /**
     * Elimina y retorna el elemento de mayor prioridad (el menor en el heap).
     *
     * @return Elemento con mayor prioridad o null si el heap está vacío.
     */
    @Override
    public E remove() {
        if (isEmpty()) return null;
        E min = data.get(0);
        E last = data.remove(data.size() - 1);
        if (!data.isEmpty()) {
            data.set(0, last);
            percolateDown(0);
        }
        return min;
    }

    /**
     * Retorna el elemento con mayor prioridad sin eliminarlo.
     *
     * @return Elemento con mayor prioridad o null si el heap está vacío.
     */
    @Override
    public E peek() {
        return isEmpty() ? null : data.get(0);
    }

    /**
     * Verifica si el heap está vacío.
     *
     * @return true si no hay elementos, false si contiene al menos uno.
     */
    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * Reordena el heap hacia arriba desde una posición específica.
     * Utilizado al agregar un nuevo elemento.
     *
     * @param idx Índice desde donde iniciar la percolación.
     */
    private void percolateUp(int idx) {
        E val = data.get(idx);
        while (idx > 0) {
            int parent = (idx - 1) / 2;
            if (val.compareTo(data.get(parent)) >= 0) break;
            data.set(idx, data.get(parent));
            idx = parent;
        }
        data.set(idx, val);
    }

    /**
     * Reordena el heap hacia abajo desde una posición específica.
     * Utilizado al remover el elemento con mayor prioridad.
     *
     * @param idx Índice desde donde iniciar la percolación.
     */
    private void percolateDown(int idx) {
        int child;
        E val = data.get(idx);
        while (idx * 2 + 1 < data.size()) {
            child = idx * 2 + 1;
            if (child + 1 < data.size() && data.get(child + 1).compareTo(data.get(child)) < 0) {
                child++;
            }
            if (data.get(child).compareTo(val) >= 0) break;
            data.set(idx, data.get(child));
            idx = child;
        }
        data.set(idx, val);
    }
}
