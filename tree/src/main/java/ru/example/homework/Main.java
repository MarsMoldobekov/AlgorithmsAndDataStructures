package ru.example.homework;

import java.util.Arrays;

public class Main {
    private static final Person[] people = {
            new Person("Nikita", 1, 20),
            new Person("Ksenia", 4, 22),
            new Person("Margarita", 6, 24),
            new Person("Marina", 2, 18),
            new Person("Denis", 3, 21),
            new Person("Natasha", 9, 19),
            new Person("Nasty", 8, 20),
            new Person("Mars", 0, 19),
            new Person("Grigory", 5, 19),
            new Person("Petr", 7, 21)
    };

    private static final Integer[] integers = {
            3, 8, 2, 0, 4, 6, 1, 7, 9, 5
    };

    private static int heapSize;

    private static final Integer integer = 8;
    private static final Person individual = new Person("Natasha", 9, 19);

    public static void main(String[] args) {
        System.out.println("---TREE OF INTEGER---");
        makeTree(integers, integer);

        System.out.println("---TREE OF PEOPLE---");
        makeTree(people, individual);

        System.out.println("---Origin array---");
        System.out.println(Arrays.toString(integers));
        System.out.println("---Sorting an array by heapsort---");
        heapsort(integers);
        System.out.println(Arrays.toString(integers));
    }

    private static <T extends Comparable<? super T>> void makeTree(T[] array, T element) {
        Tree<T> integerTree = new Tree<>();

        for (T elementOfArray : array) {
            integerTree.insert(elementOfArray);
        }

        System.out.println("IN_ORDER");
        integerTree.display(Tree.DisplayType.IN_ORDER);

        System.out.println("Minimum element...");
        System.out.println(integerTree.min());
        System.out.println("Maximum element...");
        System.out.println(integerTree.max());

        System.out.println("Deleting element...");
        integerTree.remove(element);

        System.out.println("PRE_ORDER");
        integerTree.display(Tree.DisplayType.PRE_ORDER);
    }

    private static void heapsort(Integer[] array) {
        buildHeap(array);

        while (heapSize > 1) {
            swap(0, heapSize - 1, array);
            heapSize--;
            heapify(0, array);
        }
    }

    private static void buildHeap(Integer[] array) {
        heapSize = array.length;

        for (int i = array.length / 2; i >= 0; i--) {
            heapify(i, array);
        }
    }

    private static void heapify(int i, Integer[] array) {
        int left = getLeft(i);
        int right = getRight(i);
        int largest = i;

        if (left < heapSize && array[i] < array[left]) {
            largest = left;
        }

        if (right < heapSize && array[largest] < array[right]) {
            largest = right;
        }

        if (i != largest) {
            swap(i, largest, array);
            heapify(largest, array);
        }
    }

    private static int getLeft(int i) {
        return 2 * i + 1;
    }

    private static int getRight(int i) {
        return 2 * i + 2;
    }

    private static void swap(int i, int j, Integer[] array) {
        Integer temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
