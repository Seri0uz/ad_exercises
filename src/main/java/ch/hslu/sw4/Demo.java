package ch.hslu.sw4;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

import ch.hslu.sw2.StackArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Demo {
    private static final Logger LOG = LoggerFactory.getLogger(Demo.class);
    private static final int AMOUNT = 100000;

    public static Item[] itemsArray(int n) {
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item();
        }
        return items;
    }

    public static Stack<Item> itemStack(int n) {
        Stack<Item> stack = new Stack<>();
        stack.setSize(n);
        for (int i = 0; i < n; i++) {
            stack.push(new Item());
        }
        return stack;
    }

    public static StackArray<Item> itemStackArray(int n) {
        StackArray<Item> stackArray = new StackArray<>(n);
        for (int i = 0; i < n; i++) {
            stackArray.push(new Item());
        }
        return stackArray;
    }

    public static Deque<Item> itemDeque(int n) {
        Deque<Item> deque = new ArrayDeque<>(n);
            for (int i = 0; i < n; i ++) {
                deque.push(new Item());
        }
            return deque;
    }


    public static void main(String[] args) {
        LOG.info("#### ARRAY ####");
        long start = System.nanoTime();
        itemsArray(AMOUNT);
        long end = System.nanoTime();
        LOG.info(end-start+"ns");

        LOG.info("#### Stack ####");
        start = System.nanoTime();
        itemStack(AMOUNT);
        end = System.nanoTime();
        LOG.info(end-start+"ns");

        LOG.info("#### StackArray ####");
        start = System.nanoTime();
        itemStackArray(AMOUNT);
        end = System.nanoTime();
        LOG.info(end-start+"ns");

        LOG.info("#### Deque ####");
        start = System.nanoTime();
        itemDeque(AMOUNT);
        end = System.nanoTime();
        LOG.info(end-start+"ns");
    }
}
