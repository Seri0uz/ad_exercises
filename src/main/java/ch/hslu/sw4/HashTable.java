package ch.hslu.sw4;

public class HashTable implements HashTableInterface {
    private final int size;
    private int usedSize;
    private HashItem[] items;
    public HashTable(int size) {
        this.size = size;
        this.usedSize = 0;
        this.items = new HashItem[size];
    }

    public boolean isEmpty() {
        return usedSize <= 0;
    }

    private boolean isFull() {
        return usedSize == size;
    }

    @Override
    public void clear() {
        this.items = new HashItem[size];
    }

    @Override
    public void add(Element e) {
        int index = Math.abs(e.hashCode() % size);

        this.items[index] = new HashItem(e);
        usedSize++;
    }

    @Override
    public boolean contains(Element e) {
        int index = Math.abs(e.hashCode() % size);
        return this.items[index] != null && this.items[index].getElement().equals(e);
    }

    @Override
    public boolean remove(Element e) {
        int index = Math.abs(e.hashCode() % size);
        if (this.items[index] != null) {
            this.items[index] = null;
            usedSize--;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return items.toString();
    }

}
