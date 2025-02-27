package ch.hslu.sw2;

public class List {
    private Node head;
    private Node tail;
    public List(Node value){
        this.head = value;
    }

    public int size() {
        int size = 0;
        Node current = this.head;
        while (current != null) {
            size++;
            current = current.getNextValue();
        }
        return size;
    }

    public void add(Node value){
        value.setNextValue(this.head);
        this.head = value;
    }

    public Node getHead(){
        return this.head;
    }

    public boolean getValue(int value){
        for (Node current = this.head; current != null; current = current.getNextValue()){
            if (current.getValue() == value){
                return true;
            }
        }
        return false;
    }

    public Node fifo () {
        if (this.head == null){
            return null;
        }
        Node oldHead = this.head;
        this.head = this.head.getNextValue();
        return oldHead;
    }

    public void remove(Node value){
        Node current = this.head;
        Node toRemove = null;
        while (current != null){
            if (current.getValue() == value){
                toRemove = current;
            }
            current = current.getNextValue();
        }
    }

}


