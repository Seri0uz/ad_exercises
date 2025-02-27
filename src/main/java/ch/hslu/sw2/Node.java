package ch.hslu.sw2;

import ch.hslu.sw1.Wagen;

import java.util.Objects;

public class Node {
    private int value;
    private Node nextValue;

    public Node(int value) {
        this.value = value;
    }
    public Node(int value, Node nextValue) {
        this.value = value;
        this.nextValue = nextValue;
    }
    public int getValue() {
        return value;
    }
    public Node getNextValue() {
        return nextValue;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public void setNextValue(Node value) {
        this.nextValue = value;
    }

}
