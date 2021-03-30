package ru.example.homework;

public class MyStackByLinkedList<T> {
    private final LinkedList<T> stack;

    public MyStackByLinkedList() {
        this.stack = new LinkedList<>();
    }

    public void push(T obj) {
        stack.insertAtTop(obj);
    }

    public T pop() {
        return stack.deleteFirst();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void display() {
        stack.display();
    }
}
