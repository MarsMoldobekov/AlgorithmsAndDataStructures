package ru.example.homework;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    private final static int AMOUNT_OF_PEOPLE = 4;

    private final static Person[] persons = {
            new Person("Mars"),
            new Person("Margarita"),
            new Person("Nikita"),
            new Person("Masha")
    };

    public static void main(String[] args) {
        MyStack<Person> peopleStack = new MyStack<>(AMOUNT_OF_PEOPLE);
        MyQueue<Person> peopleQueue = new MyQueue<>(AMOUNT_OF_PEOPLE);
        MyDeque<Person> peopleDeque = new MyDeque<>(AMOUNT_OF_PEOPLE);
        PriorityQueue<Person> peoplePriorityQueue = new PriorityQueue<>();

        add(persons, peopleStack);
        print(peopleStack);

        add(persons, peopleQueue);
        print(peopleQueue);

        add(persons, peopleDeque);
        print(peopleDeque);

        add(persons, peoplePriorityQueue);
        print(peoplePriorityQueue);
    }

    /*
      Задание 4.1
      Реализуйте простой стек и его базовые методы.
     */
    private static <T> void add(T[] array, MyStack<T> stack) {
        for (T element : array) {
            stack.push(element);
        }
    }

    private static <T> void print(MyStack<T> stack) {
        System.out.println("Printing stack...");

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    /*
      Задание 4.2
      Реализуйте простую очередь и его базовые методы.
     */
    private static <T> void add(T[] array, MyQueue<T> queue) {
        for (T element : array) {
            queue.insert(element);
        }
    }

    private static <T> void print(MyQueue<T> queue) {
        System.out.println("Printing queue...");

        while (!queue.isEmpty()) {
            System.out.println(queue.peek());
            queue.remove();
        }
    }

    /*
      Задание 4.3
      Реализуйте простой дек и его базовые методы.
     */
    private static <T> void add(T[] array, MyDeque<T> deque) {
        for (T element : array) {
            deque.insertFront(element);
        }
    }

    private static <T> void print(MyDeque<T> deque) {
        System.out.println("Printing deque...");

        while (!deque.isEmpty()) {
            System.out.println(deque.getRear());
            deque.deleteRear();
        }
    }

    /*
      Задание 4.4
      Реализуйте приоритетную очередь.
     */
    private static <T> void add(T[] array, PriorityQueue<T> priorityQueue) {
        priorityQueue.addAll(Arrays.asList(array));
    }

    private static <T> void print(PriorityQueue<T> priorityQueue) {
        System.out.println("Printing priority queue...");

        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.remove());
        }
    }
}
