package ru.example.homework;

import java.util.ArrayList;

/*
  Задание 4.3
  Реализуйте простой дек и его базовые методы.
 */
public class MyDeque<T> {
    private final ArrayList<T> deque;
    private final int CAPACITY;
    private final int INIT_VALUE = -1;
    private int front;
    private int rear;

    public MyDeque(int size) {
        CAPACITY = size;
        deque = new ArrayList<>(CAPACITY);
        init();
        front = INIT_VALUE;
        rear = 0;
    }

    public void insertFront(T obj) {
        if (isFull()) {
            System.out.println("Overflow\nProgram Terminated");
            System.exit(1);
        }

        if (isEmpty()) {
            front = rear = 0;
        } else if (front == 0) {
            front = CAPACITY - 1;
        } else {
            front--;
        }

        deque.set(front, obj);
    }

    public void insertRear(T obj) {
        if (isFull()) {
            System.out.println("Overflow\nProgram Terminated");
            System.exit(1);
        }

        if (isEmpty()) {
            front = rear = 0;
        } else if (rear == CAPACITY - 1) {
            rear = 0;
        } else {
            rear++;
        }

        deque.set(rear, obj);
    }

    public void deleteFront() {
        if (isEmpty()) {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(1);
        }

        deque.set(front, null);

        if (front == rear) {
            front = rear = INIT_VALUE;
        } else {
            if (front == CAPACITY - 1) {
                front = 0;
            } else {
                front++;
            }
        }
    }

    public void deleteRear() {
        if (isEmpty()) {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(1);
        }

        deque.set(rear, null);

        if (front == rear) {
            front = rear = INIT_VALUE;
        } else if (rear == 0) {
            rear = CAPACITY - 1;
        } else {
            rear--;
        }
    }

    public T getFront() {
        if (isEmpty()) {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(1);
        }

        return deque.get(front);
    }

    public T getRear() {
        if (isEmpty() || rear < 0) {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(1);
        }

        return deque.get(rear);
    }

    public boolean isEmpty() {
        return (front == INIT_VALUE);
    }

    public boolean isFull() {
        return ((front == 0 && rear == CAPACITY - 1) || front == rear + 1);
    }

    private void init() {
        for (int i = 0; i < CAPACITY; i++) {
            deque.add(null);
        }
    }
}
