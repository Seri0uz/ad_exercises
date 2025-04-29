package ch.hslu.sw9;

import ch.hslu.sw8.SortingMain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class MyApp {
    private static final Logger LOG = LoggerFactory.getLogger(MyApp.class);

    public static void main(String[] args) {
        IntegerHeap heap = new FixedSizeHeap(10);
        heap.insert(10);
        heap.insert(2);
        heap.insert(11);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);
        heap.insert(6);
        heap.insert(7);
        heap.insert(33);
        LOG.info(heap.toString());
        heap.extractMax();

        LOG.info("extract Max 33");
        LOG.info(heap.toString());
        heap.insert(13);
        LOG.info(heap.toString());
        heap.extractMax();
        LOG.info("extract Max 13");
        LOG.info(heap.toString());
        heap.extractMax();
        LOG.info("extract Max 11");
        LOG.info(heap.toString());
    }
}
