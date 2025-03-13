package ch.hslu.sw3;

public class Add extends Node {
    public Add(Number left, Number right) {
        super("ADD",left,right);
    }

    @Override
    public String toString(){
        return "("+getLeft()+" + "+getRight()+")";
    }
}
