package ch.hslu.sw3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class MathTree {
    private static final Logger LOG = LoggerFactory.getLogger(MathTree.class);

    private List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Node node = new Mul(
                new Add(new Number(2), new Number(3)),
                new Number(4)
        );

        Node node2 = new Mul(new Add(new Number(4),new Number(5)),
                new Add(new Number(2),new Number(3))
        );



        MathTree tree = new MathTree();
        MathTree tree2 = new MathTree();
        tree.toString(node);
        LOG.info(String.valueOf(node));
        LOG.info(String.valueOf(node2));

        LOG.info(""+ tree.eval(node));
        LOG.info(""+ tree2.eval(node2));
        LOG.info(""+ tree.compile(node));
        LOG.info(""+ tree2.compile(node2));
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
            return node.eval();
        }
        return 0;
    }

    public List<String> compile(Node node){
        if (node != null) {
            if (node.getOperator() == null) {
                list.add("LOAD " + node.getValue());
                return list;
            }
            else {
                compile(node.getLeft());
                compile(node.getRight());
                list.add(node.getOperator());
                return list;
            }

        }
        return null;

    }
}
