package ru.example.homework;

public class MyQueueByLinkedList<T> {
    private final DoublyLinkedList<T> queue;

    public MyQueueByLinkedList() {
        queue = new DoublyLinkedList<>();
    }

    public void insert(T obj) {
        queue.insertAtBottom(obj);
    }

    public T remove() {
        return queue.deleteFirst();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void display() {
        queue.display();
    }
}
