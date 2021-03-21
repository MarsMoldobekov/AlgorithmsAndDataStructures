package ru.example.lesson1;

import java.util.Arrays;

public class Main {
    private static record Person(String name) {

    }

    public static void main(String[] args) {
        /*Задание 2.1
          На основе программного кода из задания №1
          реализуйте массив на основе существующих примитивных или ссылочных типов данных.
          Выполните обращение к массиву и базовые операции класса Arrays.
        */
        String[] lines = {
                "Hello, world!", "True", "False", "Cat", "Dog"
        };
        String[] newLines = copyArray(lines);

        int[] numbers = {
                9, 3, 2, 8, 4, 5, 6, 7, 1, 0
        };

        Person[] persons = {
                new Person("Mars"),
                new Person("Andrey"),
                new Person("Nikita"),
                new Person("Konstantin")
        };

        printArray(newLines);
        printArray(persons);

        compareArrays(lines, newLines);
    }

    private static <T> T[] copyArray(T[] array) {
        return Arrays.copyOf(array, array.length);
    }

    private static <T> void printArray(T[] array) {
        System.out.println(Arrays.toString(array));
    }

    private static <T> void compareArrays(T[] array, T[] anotherArray) {
        System.out.println(Arrays.equals(array, anotherArray));
    }
}
