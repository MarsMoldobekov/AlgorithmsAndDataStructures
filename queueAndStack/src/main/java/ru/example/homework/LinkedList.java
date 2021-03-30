package ru.example.homework;

public class LinkedList<T> {
    protected static class Node<T> {
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

    public T deleteFirst() {
        Node<T> temp = firstNode;
        firstNode = firstNode.getNextNode();
        return temp.getObj();
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
