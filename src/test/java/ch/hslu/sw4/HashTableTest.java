package ch.hslu.sw4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {
    @Test
    public void testHashTableAddElement() {
        HashTable hashTable = new HashTable(10);
        hashTable.add(new Element("Hydrogen",1));
        assertTrue(hashTable.contains(new Element("Hydrogen",1)));
    }

    @Test
    public void testHashTableRemoveElement() {
        HashTable hashTable = new HashTable(10);
        hashTable.add(new Element("Hydrogen",1));
        hashTable.remove(new Element("Hydrogen",1));
        assertFalse(hashTable.contains(new Element("Hydrogen",1)));
    }

    @Test
    public void testHashTableCollision() {
        HashTable hashTable = new HashTable(100);
        hashTable.add(new Element("Hydrogen",1));
        hashTable.add(new Element("Barium",56));
        hashTable.add(new Element("Helium",2));
        assertTrue(hashTable.contains(new Element("Barium",56)));
    }

}