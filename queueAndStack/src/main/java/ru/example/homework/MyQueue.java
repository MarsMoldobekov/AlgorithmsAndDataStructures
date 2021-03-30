package ru.example.homework;

import java.util.ArrayList;

/*
  Задание 4.2
  Реализуйте простую очередь и его базовые методы.
 */
public class MyQueue<T> {
    private final ArrayList<T> queue;
    private final int CAPACITY;
    private int front;
    private int rear;
    private int count;

    public MyQueue(int size) {
        CAPACITY = size;
        queue = new ArrayList<>(CAPACITY);
        init();
        front = 0;
        count = 0;
        rear = -1;
    }

    public void remove() {
        if (isEmpty()) {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(1);
        }

        System.out.println("Removing " + queue.get(front));
        queue.set(front, null);
        front = (front + 1) % CAPACITY;
        count--;
    }

    public void insert(T obj) {
        if (isFull()) {
            System.out.println("Overflow\nProgram Terminated");
            System.exit(1);
        }

        System.out.println("Inserting " + obj);

        rear = (rear + 1) % CAPACITY;
        queue.set(rear, obj);
        count++;
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(1);
        }

        return queue.get(front);
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return (count == 0);
    }

    public boolean isFull() {
        return (count == CAPACITY);
    }

    private void init() {
        for (int i = 0; i < CAPACITY; i++) {
            queue.add(null);
        }
    }
}
