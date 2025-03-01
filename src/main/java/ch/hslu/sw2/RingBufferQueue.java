package ch.hslu.sw2;

import java.util.Arrays;

public final class RingBufferQueue implements Queue {
    private int readerPosition = 0;
    private int writerPosition = 0;
    private int size = 0;
    private char[] buffer;

    public RingBufferQueue(int size) {
        buffer = new char[size];
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean isFull() {
        return this.size == this.buffer.length;
    }

    @Override
    public int size() {
        return this.size;
    }

     @Override
    public void enqueue(char character) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }

        this.buffer[this.writerPosition] = character;
        this.size++;
        this.writerPosition++;
        if(this.writerPosition >= this.buffer.length) {
            this.writerPosition -= this.buffer.length;
        }
     }

     @Override
    public char dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        char character = this.buffer[readerPosition];
        this.size--;
        this.readerPosition++;
        if(this.readerPosition >= this.buffer.length) {
            this.readerPosition -= this.buffer.length;
        }
        return character;
     }

     @Override
    public String toString() {
        return "Buffersize: " + size + " ReaderPosition: " + readerPosition + " WriterPosition: " + writerPosition + "\nBuffer: " + Arrays.toString(buffer);
     }
}
