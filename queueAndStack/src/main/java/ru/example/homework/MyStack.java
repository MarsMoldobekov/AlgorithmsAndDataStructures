package ru.example.homework;

import java.util.ArrayList;

/*
  Задание 4.1
  Реализуйте простой стек и его базовые методы.
 */
public class MyStack<T> {
    private final ArrayList<T> stack;
    private final int CAPACITY;
    private final int INIT_VALUE = -1;
    private int top;

    public MyStack(int size) {
        CAPACITY = size;
        stack = new ArrayList<>(CAPACITY);
        top = INIT_VALUE;
    }

    public void push(T obj) {
        if (isFull()) {
            System.out.println("Overflow\nProgram Terminated");
            System.exit(1);
        }

        ++top;
        stack.add(obj);
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(1);
        }

        T temp = stack.get(top);
        stack.set(top--, null);
        return temp;
    }

    public T peek() {
        return stack.get(top);
    }

    public boolean isEmpty() {
        return (top == INIT_VALUE);
    }

    public boolean isFull() {
        return (top == (CAPACITY - 1));
    }
}
