package ru.example.homework;

import java.util.Arrays;
import java.util.Random;

public class Main {
    private final static int ARRAY_SIZE = 10;

    public static void main(String[] args) {
        int[] array = new int[ARRAY_SIZE];
        Random random = new Random();

        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = random.nextInt(ARRAY_SIZE);
        }

        System.out.println(Arrays.toString(sortMerge(array)));
    }

    /*
      Задание 5.2
      Реализуйте простой пример бесконечной рекурсии и обычной рекурсии с условием для выхода.
    */
    private static void print(int value) {
        System.out.println(value);
        print(value - 1);
    }

    private static void printR(int value) {
        if (value >= 0) {
            System.out.println(value);
            printR(value - 1);
        }
    }

    /*
      Задание 5.4
      Реализуйте простой алгоритм использующий цикл и простой алгоритм использующий рекурсию.
      Возведение числа в степень.
    */
    private static int pow(int value, int powValue) {
        int result = 1;

        for (int i = 0; i < powValue; i++) {
            result *= value;
        }

        return result;
    }

    private static int powR(int value, int powValue) {
        if (powValue == 1) {
            return value;
        } else {
            return value * powR(value, powValue - 1);
        }
    }

    /*
      Задание 5.5
      Реализуйте алгоритм двоичного рекурсивного поиска на основе массива из задания 2.1.
    */
    private static int binarySearch(int key, int low, int high, int[] array) {
        if (low > high) {
            return array.length;
        }

        int middle = (low + high) / 2;

        if (array[middle] == key) {
            return middle;
        } else if (array[middle] < key) {
            return binarySearch(key, middle + 1, high, array);
        } else {
            return binarySearch(key, low, middle - 1, array);
        }
    }

    /*
      Задание 5.6
      Реализуйте алгоритм сортировки слиянием.
    */
    private static int[] sortMerge(int[] array) {
        int length = array.length;

        if (length < 2) {
            return array;
        }

        int middle = length / 2;

        return merge(
                sortMerge(Arrays.copyOfRange(array, 0, middle)),
                sortMerge(Arrays.copyOfRange(array, middle, length))
        );
    }

    private static int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int aIndex = 0;
        int bIndex = 0;

        for (int i = 0; i < result.length; i++) {
            result[i] = a[aIndex] < b[bIndex] ? a[aIndex++] : b[bIndex++];

            if (aIndex == a.length) {
                System.arraycopy(b, bIndex, result, ++i, b.length - bIndex);
                break;
            }

            if (bIndex == b.length) {
                System.arraycopy(a, aIndex, result, ++i, a.length - aIndex);
                break;
            }
        }

        return result;
    }
}
