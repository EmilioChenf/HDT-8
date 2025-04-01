package utils;

import java.util.ArrayList;

public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {
    protected ArrayList<E> data;

    public VectorHeap() {
        data = new ArrayList<>();
    }

    public void add(E value) {
        data.add(value);
        percolateUp(data.size() - 1);
    }

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

    public E peek() {
        return isEmpty() ? null : data.get(0);
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

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
