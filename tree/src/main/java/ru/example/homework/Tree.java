package ru.example.homework;

public class Tree<T extends Comparable<? super T>> {
    public enum DisplayType {
        PRE_ORDER, IN_ORDER, POST_ORDER
    }

    private Node<T> root;

    public Tree() {
        this.root = null;
    }

    public void insert(T data) {
        insert(root, new Node<>(data));
    }

    private Node<T> insert(Node<T> current, final Node<T> node) {
        if (root == null) {
            root = node;
            return root;
        }

        if (current == null) {
            return node;
        }

        if (current.compareTo(node) > 0) {
            current.setLeftChild(insert(current.getLeftChild(), node));
        }

        if (current.compareTo(node) < 0) {
            current.setRightChild(insert(current.getRightChild(), node));
        }

        return current;
    }

    public Node<T> find(T data) {
        if (root == null) {
            return null;
        }

        Node<T> node = new Node<>(data);
        return find(root, node);
    }

    private Node<T> find(Node<T> current, final Node<T> node) {
        if (current == null) {
            current = root;
        }

        if (current.compareTo(node) == 0) {
            return current;
        } else if (current.compareTo(node) < 0 && current.getRightChild() != null) {
            return find(current.getRightChild(), node);
        } else if (current.compareTo(node) > 0 && current.getLeftChild() != null) {
            return find(current.getLeftChild(), node);
        }

        return null;
    }

    public Node<T> min() {
        if (root == null) {
            return null;
        }

        return min(root);
    }

    private Node<T> min(Node<T> current) {
        if (current == null) {
            current = root;
        }

        if (current.getLeftChild() == null) {
            return current;
        } else {
            return min(current.getLeftChild());
        }
    }

    public Node<T> max() {
        if (root == null) {
            return null;
        }

        return max(root);
    }

    private Node<T> max(Node<T> current) {
        if (current == null) {
            current = root;
        }

        if (current.getRightChild() == null) {
            return current;
        } else {
            return max(current.getRightChild());
        }
    }

    public void remove(T data) {
        remove(data, root);
    }

    private Node<T> remove(T data, Node<T> parent) {
        if (parent == null) {
            return null;
        }

        if (data.compareTo(parent.getData()) < 0) {
            parent.setLeftChild(remove(data, parent.getLeftChild()));
        } else if (data.compareTo(parent.getData()) > 0) {
            parent.setRightChild(remove(data, parent.getRightChild()));
        } else {
            if (parent.getLeftChild() == null) {
                return parent.getRightChild();
            } else if (parent.getRightChild() == null) {
                return parent.getLeftChild();
            }

            parent.setData(inOrderSuccessor(parent.getRightChild()));
            parent.setRightChild(remove(parent.getData(), parent.getRightChild()));
        }

        return parent;
    }

    private T inOrderSuccessor(Node<T> node) {
        T min = node.getData();

        while (node.getLeftChild() != null) {
            min = node.getLeftChild().getData();
            node = node.getLeftChild();
        }

        return min;
    }

    public void display(DisplayType displayType) {
        switch (displayType) {
            case PRE_ORDER -> preOrder(root);
            case IN_ORDER -> inOrder(root);
            case POST_ORDER -> postOrder(root);
        }
    }

    private void preOrder(Node<T> node) {
        if (node != null) {
            System.out.println(node);
            preOrder(node.getLeftChild());
            preOrder(node.getRightChild());
        }
    }

    private void inOrder(Node<T> node) {
        if (node != null) {
            inOrder(node.getLeftChild());
            System.out.println(node);
            inOrder(node.getRightChild());
        }
    }

    private void postOrder(Node<T> node) {
        if (node != null) {
            postOrder(root.getLeftChild());
            postOrder(node.getRightChild());
            System.out.println(node);
        }
    }
}
