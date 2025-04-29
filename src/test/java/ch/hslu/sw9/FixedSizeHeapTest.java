package ch.hslu.sw9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FixedSizeHeapTest {

    @Test
    public void insertExtractHeap() {
        FixedSizeHeap fh = new FixedSizeHeap(10);
        fh.insert(1);
        fh.insert(10);
        fh.insert(2);
        fh.insert(11);

        assertEquals(11, fh.extractMax());
    }

    @Test
    public void extractEmptyHeap() {
        final Exception e = assertThrows(RuntimeException.class, () -> {
            FixedSizeHeap fh = new FixedSizeHeap(10);
            fh.extractMax();
        });

        assertEquals("Heap is empty", e.getMessage());
    }

    @Test
    public void insertFullHeap() {
        final Exception e = assertThrows(RuntimeException.class, () -> {
            FixedSizeHeap fh = new FixedSizeHeap(4);
            fh.insert(1);
            fh.insert(10);
            fh.insert(2);
            fh.insert(11);
            fh.insert(3);
        });

        assertEquals("Heap is full", e.getMessage());
    }

    @Test
    public void testReOrganizeHeap() {
        FixedSizeHeap fh = new FixedSizeHeap(10);
        fh.insert(1);
        fh.insert(10);
        fh.insert(2);
        fh.insert(11);
        fh.extractMax();
        fh.extractMax();
        fh.insert(0);

        assertEquals(2, fh.extractMax());
    }

    @Test
    public void testReOrganizeHeapSameValues() {
        FixedSizeHeap fh = new FixedSizeHeap(10);
        fh.insert(1);
        fh.insert(10);
        fh.insert(2);
        fh.insert(11);
        fh.insert(11);
        fh.insert(11);
        fh.extractMax();
        fh.extractMax();
        assertEquals(11, fh.extractMax());
    }


}