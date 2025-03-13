package ch.hslu.sw3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MathTree {
    private static final Logger LOG = LoggerFactory.getLogger(MathTree.class);
    public static void main(String[] args) {
        Node node = new Mul(
                new Add(new Number(2), new Number(3)),
                new Number(4)
        );


        MathTree tree = new MathTree();
        tree.toString(node);
        LOG.info(String.valueOf(node));

        LOG.info(""+ tree.eval(node));
    }

    public String toString(Node node) {
        if (node != null) {
            toString(node.getLeft());
            toString(node.getRight());
        }
        return "";
    }

    public int eval(Node node) {
        if (node != null) {
            eval(node.getLeft());
            eval(node.getRight());

            if (node.getOperator() != null && node.getOperator().equals("+")) {
                return node.getLeft().getValue() + node.getRight().getValue();
            }
            if (node.getOperator() != null && node.getOperator().equals("*")) {
                return node.getLeft().getValue() * node.getRight().getValue();
            }
            return node.getValue();
        }
        return 0;
    }
}
