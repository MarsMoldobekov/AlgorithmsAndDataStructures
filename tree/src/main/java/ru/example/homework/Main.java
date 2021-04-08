package ru.example.homework;

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

    private static final Integer integer = 8;
    private static final Person individual = new Person("Natasha", 9, 19);

    public static void main(String[] args) {
        System.out.println("---TREE OF INTEGER---");
        makeTree(integers, integer);

        System.out.println("---TREE OF PEOPLE---");
        makeTree(people, individual);
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
}
