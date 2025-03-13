package ch.hslu.sw3;

public class Number extends Node {
    private int number;

    public Number(int value) {
        super(value);
        this.number = value;

    }

    public String toString(){
        return number+"";
    }
}
