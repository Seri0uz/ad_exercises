package ch.hslu.sw2;

import java.util.Objects;

public class Node<T> {
    private final T value;
    private Node<T> nextValue;

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void link(Node<T> next){
        this.nextValue = next;
    }

    public Node<T> getNext() {
        return nextValue;
    }

    public boolean hasNext() {
        return nextValue != null;
    }

    @Override
    public String toString() {
        return value + " -> " + nextValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        return (o instanceof Node node)
                && Objects.equals(this.value, node.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
