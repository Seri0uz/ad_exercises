package ch.hslu.sw2;

public class List<T> {
    private Node<T> head;
    private int size = 0;
    public List(){
        this.head = null;
    }

    public int size() {
        return this.size;
    }

    public void add(Node<T> node){
        node.link(this.head);
        this.head = node;
        size++;
    }

    public Node<T> getHead(){ // nie Methoden schreiben nur für den Test!! Gefährlich, da es die ganze Liste zurückgibt
        return this.head;
    }

    public boolean search(T value){
        for (Node<T> current = this.head; current != null; current = current.getNext()){
            if (current.getValue().equals(value)){
                return true;
            }
        }
        return false;
    }

    public Node<T> pop() {
        if (this.head == null){
            return null;
        }
        Node<T> oldHead = this.head;
        this.head = this.head.getNext();
        size--;
        return oldHead;
    }

    public boolean remove(T value){
        Node<T> current = head;
        Node<T> prev = head;

        if (head == null) {
            return false; // Liste ist leer
        }
        if (current.getValue().equals(value)) {
            pop();
            return true;
        }

        while (current.hasNext()) {
            current = current.getNext();
            if (value.equals(current.getValue())) {
                prev.link(current.getNext());
                this.size--;
                return true;
            }
            prev = current;
        }
        return false;
    }
}


