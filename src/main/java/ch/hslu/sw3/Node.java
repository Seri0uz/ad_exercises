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
        this.left = left;
        this.right = right;
        this.operator = operator;
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

    public int eval() {
        if (operator != null) {
            if (operator.equals("ADD")) {
                this.value = left.getValue() + right.getValue();
                return value;
            }
            if (operator.equals("MUL")) {
                this.value = left.getValue() * right.getValue();
                return value;
            }
        }
        return value;
    }

    @Override
    public String toString() {
        String leftValue = (left != null) ? String.valueOf(left.getValue()) : "null";
        String rightValue = (right != null) ? String.valueOf(right.getValue()) : "null";

        return "value=  " + value + ", left=" + leftValue + ", right=" + rightValue;
    }


}
