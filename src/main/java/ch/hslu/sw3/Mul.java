package ch.hslu.sw3;

public class Mul extends Node {
    public Mul(Node left, Node right) {
        super("MUL",left, right);
    }

    @Override
    public String toString(){
        return "("+getLeft()+" * "+getRight()+")";
    }
}
