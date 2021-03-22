package ru.example.howework;

import java.util.Arrays;
import java.util.List;

public class Main {
    private static record Person(String name) {

    }

    private static class Node<T> {
        private final T obj;
        private Node<T> nextNode;
        private Node<T> previousNode;

        public Node(T obj, Node<T> nextNode, Node<T> previousNode) {
            this.obj = obj;
            this.nextNode = nextNode;
            this.previousNode = previousNode;
        }

        public Node<T> getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node<T> nextNode) {
            this.nextNode = nextNode;
        }

        public Node<T> getPreviousNode() {
            return previousNode;
        }

        public void setPreviousNode(Node<T> previousNode) {
            this.previousNode = previousNode;
        }

        public T getObj() {
            return obj;
        }
    }

    /*
      Задание 3.3
      Реализуйте простой односвязный список и его базовые методы.
     */
    private static class LinkedList<T> {
        protected Node<T> firstNode;

        public LinkedList() {
            firstNode = null;
        }

        public boolean isEmpty() {
            return firstNode == null;
        }

        public void insertAtTop(T obj) {
            this.firstNode = new Node<>(obj, firstNode, null);
        }

        public Node<T> deleteFirst() {
            Node<T> temp = firstNode;
            firstNode = firstNode.getNextNode();
            return temp;
        }

        public void display() {
            Node<T> current = firstNode;

            while (current != null) {
                System.out.println(current.getObj());
                current = current.getNextNode();
            }
        }

        public Node<T> find(T obj) {
            Node<T> current = firstNode;

            while (current != null) {
                if (current.getObj().equals(obj)) {
                    return current;
                }

                current = current.getNextNode();
            }

            return null;
        }
    }

    /*
      Задание 3.4
      На основе списка из задания 3.1 реализуйте простой двусторонний список и его базовые методы.
      Реализуйте список заполненный объектами из вашего класса из задания 1.3
     */
    private static class DoublyLinkedList<T> extends LinkedList<T> {
        private Node<T> lastNode;

        public DoublyLinkedList() {
            super();
            lastNode = null;
        }

        @Override
        public boolean isEmpty() {
            return firstNode == null && lastNode == null;
        }

        @Override
        public void insertAtTop(T obj) {
            Node<T> node = new Node<>(obj, null, null);

            if (firstNode == null && lastNode == null) {
                firstNode = lastNode = node;
            } else {
                node.setNextNode(firstNode);
                firstNode.setPreviousNode(node);
                firstNode = node;
            }
        }

        public void insertAtBottom(T obj) {
            Node<T> node = new Node<>(obj, null, null);

            if (firstNode == null && lastNode == null) {
                firstNode = lastNode = node;
            } else {
                node.setPreviousNode(lastNode);
                lastNode.setNextNode(node);
                lastNode = node;
            }
        }

        @Override
        public Node<T> deleteFirst() {
            Node<T> temp;

            if (firstNode == null && lastNode == null) {
                temp = null;
            } else if (firstNode == lastNode) {
                temp = firstNode;
                firstNode = lastNode = null;
            } else {
                temp = firstNode;
                firstNode = firstNode.getNextNode();
                temp.setNextNode(null);
                firstNode.setPreviousNode(null);
            }

            return temp;
        }

        public Node<T> deleteLast() {
            Node<T> temp;

            if (firstNode == null && lastNode == null) {
                temp = null;
            } else if (firstNode == lastNode) {
                temp = lastNode;
                firstNode = lastNode = null;
            } else {
                temp = lastNode;
                lastNode = lastNode.getPreviousNode();
                temp.setPreviousNode(null);
                lastNode.setNextNode(null);
            }

            return temp;
        }

        public Iterator<T> iterator() {
            return new Iterator<>(firstNode);
        }
    }

    /*
      Задание 3.5
      Реализуйте итератор на основе связанных списков из задания 3.4 и выполните базовые операции итератора.
     */
    private static class Iterator<T> {
        private Node<T> current;

        public Iterator(Node<T> current) {
            this.current = current;
        }

        public boolean hasNext() {
            return current.getNextNode() != null;
        }

        public boolean hasPrevious() {
            return current.getPreviousNode() != null;
        }

        public Node<T> next() {
            Node<T> previous = current;
            current = current.getNextNode();
            return previous;
        }

        public Node<T> previous() {
            Node<T> next = current;
            current = current.getPreviousNode();
            return next;
        }
    }

    public static void main(String[] args) {
        String[] lines = {"Hello, world!", "True", "False", "Cat", "Dog"};
        String[] names = {"Mars", "Nikita", "Margarita"};
        Person[] persons = {
                new Person("Mars"),
                new Person("Andrey"),
                new Person("Nikita"),
                new Person("Konstantin")
        };

        List<String> stringList = createList(lines);
        printList(stringList);

        LinkedList<String> list = new LinkedList<>();
        DoublyLinkedList<String> doublyLinkedList = new DoublyLinkedList<>();
        DoublyLinkedList<Person> personDoublyLinkedList = new DoublyLinkedList<>();

        display(list, lines);
        display(doublyLinkedList, names);
        display(personDoublyLinkedList, persons);

        display(doublyLinkedList);
        display(personDoublyLinkedList);
    }

    /*
      Задание 3.1
      На основе массива из домашнего задания 2.1 реализуйте простой список и коллекцию.
     */
    private static <T> List<T> createList(T[] array) {
        return Arrays.asList(array);
    }

    /*
      Задание 3.2
      На основе списка из задания 3.1 реализуйте основные методы добавления, удаления и получения объекта из списка.
      Оценить выполненные методы с помощью базового класса System.nanoTime().
     */
    private static <T> void add(List<T> list, T obj) {
        long l = System.nanoTime();
        list.add(obj);
        System.out.println("Время выполнения операции добавления элемента в список: " + (System.nanoTime() - l));
    }

    private static <T> T delete(List<T> list, int index) {
        return list.remove(index);
    }

    private static <T> T get(List<T> list, int index) {
        return list.get(index);
    }

    private static <T> void printList(List<T> list) {
        for (T t : list) {
            System.out.println(t);
        }
    }

    private static <T> void display(LinkedList<T> list, T[] array) {
        for (T element : array) {
            list.insertAtTop(element);
        }

        list.display();
    }

    private static <T> void display(DoublyLinkedList<T> list) {
        Iterator<T> iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
