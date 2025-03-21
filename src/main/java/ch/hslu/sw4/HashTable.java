package ch.hslu.sw4;

import ch.hslu.sw2.Node;

public class HashTable implements HashTableInterface {
    private static final Node<Element> TOMBSTONE = new Node<>(new Element("Tombstone",0));

    private final int size;
    private int usedSize;
    private Node<Element>[] items;
    public HashTable(int size) {
        this.size = size;
        this.usedSize = 0;
        this.items = new Node[size];
    }

    public boolean isEmpty() {
        return usedSize <= 0;
    }

    private boolean isFull() {
        return usedSize == size;
    }

    @Override
    public void clear() {
        this.items = new Node[size];
    }

    @Override
    public boolean add(Element e) {
        if (isFull()) {
            return false;
        }

        int index = Math.abs(e.hashCode() % size);

        while (hasNext(index)){
            if (index > this.size) { // end reached
                return false;
            }
            if(items[index].getValue().equals(e)){ // duplicates not allowed
                return false;
            }

            index++;
        }

        this.items[index] = new Node<Element>(,e);
        this.usedSize++;
        return true;
    }

    private boolean hasNext(int index){
        return index < this.size && this.items[index] != null;
    }

    @Override
    public boolean contains(Element e) {
        int index = Math.abs(e.hashCode() % this.size);

        while (hasNext(index)) {
            if (this.items[index] != null && this.items[index].getValue().equals(e)) {
                return true;
            }
            index++;
        }
        return false;
    }

    @Override
    public boolean remove(Element e) {
        if (isEmpty()) {
            return false;
        }
        int index = Math.abs(e.hashCode() % size);
        while (hasNext(index)) {
            if (items[index].getValue().equals(e)) {
                this.items[index] = TOMBSTONE;
                this.usedSize--;
                return true;
        }
            index++;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i<size;i++){
            if(items[i] != null){
                stringBuilder.append(items[i]);
            }else{
                stringBuilder.append("[NULL]");
            }
        }

        return stringBuilder.toString();
    }

}
