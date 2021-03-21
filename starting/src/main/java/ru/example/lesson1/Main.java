package ru.example.lesson1;

import java.util.Arrays;
import java.util.Random;

public class Main {
    private static record Person(String name) {

    }

    private static final int ARRAY_SIZE = 400;

    public static void main(String[] args) {
        /*
          Задание 2.1
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

    /*
      Задание 2.2
      На основе написанного кода в задании 2.1 реализуйте линейный и двоичный поиск.
      Оценить алгоритмы линейного и двоичного поиска с помощью базового класса System.nanoTime().
     */
    private static <T> int find(T[] array, T obj) {
        long l = System.nanoTime();

        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(obj)) {
                System.out.println(l - System.nanoTime());

                return i;
            }
        }

        return -1;
    }

    private static int binarySearch(int[] array, int element) {
        int begin = 0;
        int end = array.length - 1;
        long l = System.nanoTime();

        while (begin <= end) {
            int middle = (begin + end) / 2;

            if (array[middle] == element) {
                System.out.println(l - System.nanoTime());

                return middle;
            } else if (array[middle] < element) {
                begin = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        return -1;
    }

    /*
      Задание 2.3
      Создайте массив размером 400 элементов. Выполните сортировку с помощью метода sort().
      Оцените сортировку с помощью базового класса System.nanoTime().
     */
    private static void sort() {
        int[] array = new int[ARRAY_SIZE];
        Random random = new Random();

        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = random.nextInt(100);
        }

        long l = System.nanoTime();
        Arrays.sort(array);
        System.out.println(l - System.nanoTime());
    }


}
