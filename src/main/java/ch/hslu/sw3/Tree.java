package ch.hslu.sw3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Tree implements TreeInterface {
    private Node root;
    private static final Logger LOG = LoggerFactory.getLogger(Tree.class);

    public Tree(Node root) {
        this.root = root;
    }

    public static void main(String[] args) {
        Node root = new Node(9);
        Node c = new Node(3);
        Node a = new Node(1);
        Node f = new Node(6);
        Node e = new Node(5);
        Node j = new Node(10);
        Node h = new Node(8);
        Node n = new Node(14);
        Node m = new Node(13);
        Node z = new Node(26);

        root.setLeft(c);
        root.setRight(j);
        c.setLeft(a);
        c.setRight(f);
        f.setLeft(e);
        f.setRight(h);
        j.setRight(n);
        n.setLeft(m);
        n.setRight(z);

        Tree tree = new Tree(root);
        tree.search(root, 5);
        LOG.info("------");
        tree.add(root, 24);
        LOG.info("------");
        tree.search(root, 24);
        LOG.info("------");
        tree.inorderTraversalRec(root);
    }



    public Node add(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.getValue()) {
            node.setLeft(add(node.getLeft(), value));
        }
        if (value > node.getValue()) {
            node.setRight(add(node.getRight(), value));
        }
        return node;
    }

    public Node search(Node node, int value) {
        LOG.info(String.valueOf(node));
        if (node == null) {
            return null;
        }

        if (node.getValue() == value) {
            return node;
        }

        if (value < node.getValue()) {
            return search(node.getLeft(), value);
        }

        if (value > node.getValue()) {
            return search(node.getRight(), value);
        }

        return null;
    }

    private void inorderTraversalRec(Node node) {
        if (node != null) {
            // Zuerst linker Teilbaum
            inorderTraversalRec(node.getLeft());
            // Dann aktueller Knoten
            LOG.info("Node " + node.getValue());
            // Zuletzt rechter Teilbaum
            inorderTraversalRec(node.getRight());
        }
    }

}
