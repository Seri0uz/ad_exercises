package ch.hslu.sw4;

import ch.hslu.sw2.Node;

import java.util.Objects;

public class Element {
    private final String name;
    private final int number;
    public Element(String name, int number) {
        this.name = name;
        this.number = number;
    }
    public String getName() {
        return name;
    }
    public int getNumber() {
        return number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        return (obj instanceof Element element)
            && Objects.equals(this.name, element.name);
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Number: " + number;
    }
}
