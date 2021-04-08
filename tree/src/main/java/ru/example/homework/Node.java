package ru.example.homework;

public class Node<T extends Comparable<? super T>> implements Comparable<Node<T>> {
    private Node<T> leftChild;
    private Node<T> rightChild;
    private T data;

    public Node(T data) {
        leftChild = rightChild = null;
        this.data = data;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }

    @Override
    public int compareTo(Node<T> o) {
        return data.compareTo(o.getData());
    }
}
