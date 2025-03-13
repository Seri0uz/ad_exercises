package ch.hslu.sw3;

public class Node {
    private int value;
    private Node left;
    private Node right;
    private String operator;

    public Node(int value) {
        this.value = value;
    }

    public Node(String operator, Node left, Node right) {
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public String getOperator() {
        return operator;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }
    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        String leftValue = (left != null) ? String.valueOf(left.getValue()) : "null";
        String rightValue = (right != null) ? String.valueOf(right.getValue()) : "null";

        return "value=  " + value + ", left=" + leftValue + ", right=" + rightValue;
    }


}
