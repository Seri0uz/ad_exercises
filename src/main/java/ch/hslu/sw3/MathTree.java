package ch.hslu.sw3;

public class MathTree {
    public static void main(String[] args) {
        Node node = new Mul(
                new Add(new Number(2), new Number(3)),
                new Number(4)
        );

        Node node2 = new Mul(new Number(2),new Number(3));

        MathTree tree = new MathTree();
        tree.toString(node);
    }

    public String toString(Node node) {
        if (node != null) {
            toString(node.getLeft());
            System.out.print(node);
            toString(node.getRight());
        }
       return "";
    }
}
