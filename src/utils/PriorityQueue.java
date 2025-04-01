package utils;

public interface PriorityQueue<E extends Comparable<E>> {
    public void add(E value);
    public E remove();
    public E peek();
    public boolean isEmpty();
}
