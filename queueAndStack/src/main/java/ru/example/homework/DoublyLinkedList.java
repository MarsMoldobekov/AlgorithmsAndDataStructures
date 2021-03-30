package ru.example.homework;

public class DoublyLinkedList<T> extends LinkedList<T> {
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

        if (isEmpty()) {
            firstNode = lastNode = node;
        } else {
            node.setNextNode(firstNode);
            firstNode.setPreviousNode(node);
            firstNode = node;
        }
    }

    public void insertAtBottom(T obj) {
        Node<T> node = new Node<>(obj, null, null);

        if (isEmpty()) {
            firstNode = lastNode = node;
        } else {
            node.setPreviousNode(lastNode);
            lastNode.setNextNode(node);
            lastNode = node;
        }
    }

    @Override
    public T deleteFirst() {
        Node<T> temp;

        if (isEmpty()) {
            return null;
        } else if (firstNode == lastNode) {
            temp = firstNode;
            firstNode = lastNode = null;
        } else {
            temp = firstNode;
            firstNode = firstNode.getNextNode();
            temp.setNextNode(null);
            firstNode.setPreviousNode(null);
        }

        return temp.getObj();
    }

    public T deleteLast() {
        Node<T> temp;

        if (isEmpty()) {
            return null;
        } else if (firstNode == lastNode) {
            temp = lastNode;
            firstNode = lastNode = null;
        } else {
            temp = lastNode;
            lastNode = lastNode.getPreviousNode();
            temp.setPreviousNode(null);
            lastNode.setNextNode(null);
        }

        return temp.getObj();
    }
}
