package ru.example.homework;

public class HashTable {
    private final Item[] hashArray;
    private final int size;
    private final Item nonItem;

    public HashTable(int size) {
        this.size = size;
        hashArray = new Item[size];
        nonItem = new Item(-1);
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            if (hashArray[i] != null) {
                System.out.println(hashArray[i].getData());
            } else {
                System.out.println("***");
            }
        }
    }

    public int hash(int key) {
        return key & size;
    }

    public int hashDouble(int key) {
        return 5 - key % 5;
    }

    public void insert(Item item) {
        int key = item.getData();
        int hashValue = hash(key);
        int step = hashDouble(key);

        while (hashArray[hashValue] != null && hashArray[hashValue].getData() != -1) {
            hashValue = (hashValue + step) % size;
        }

        hashArray[hashValue] = item;
    }

    public Item delete(int key) {
        int hashValue = hash(key);
        int step = hashDouble(key);

        while (hashArray[hashValue] != null) {
            if (hashArray[hashValue].getData() == key) {
                Item temp = hashArray[hashValue];
                hashArray[hashValue] = nonItem;
                return temp;
            }

            hashValue = (hashValue + step) % size;
        }

        return nonItem;
    }

    public Item find(int key) {
        int hashValue = hash(key);
        int step = hashDouble(key);

        while (hashArray[hashValue] != null) {
            if (hashArray[hashValue].getData() == key) {
                return hashArray[hashValue];
            }

            hashValue = (hashValue + step) % size;
        }

        return nonItem;
    }
}
