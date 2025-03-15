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
    public void testHashTableFull() {
        HashTable hashTable = new HashTable(5);
        hashTable.add(new Element("Hydrogen",1));
        hashTable.add(new Element("t",56));
        hashTable.add(new Element("s",11));
        hashTable.add(new Element("aa",56));
        hashTable.add(new Element("ten",56));

        assertFalse(hashTable.add(new Element("Hydrogen",1)));
    }

    @Test
    public void testHashTableFullRemoval() {
        HashTable hashTable = new HashTable(5);
        hashTable.add(new Element("Hydrogen",1));
        hashTable.add(new Element("t",56));
        hashTable.add(new Element("s",11));
        hashTable.add(new Element("aa",56));
        hashTable.add(new Element("ten",56));
        hashTable.remove(new Element("t",56));
        assertFalse(hashTable.contains(new Element("t",56)));
    }

}