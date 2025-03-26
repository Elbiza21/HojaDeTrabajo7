package Main.Java;

import java.util.ArrayList;
import java.util.List;


public class BST<E extends Comparable<E>> {
    private Node<E> root;


    public static class Node<E> {
        E data;
        Node<E> left;
        Node<E> right;

        public Node(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }


    public BST() {
        this.root = null;
    }


    public void insert(E data) {
        root = insertRec(root, data);
    }

    private Node<E> insertRec(Node<E> root, E data) {
        if (root == null) {
            root = new Node<>(data);
            return root;
        }

        if (data.compareTo(root.data) < 0) {
            root.left = insertRec(root.left, data);
        } else if (data.compareTo(root.data) > 0) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }


    public E search(E key) {
        Node<E> result = searchRec(root, key);
        return (result == null) ? null : result.data;
    }

    private Node<E> searchRec(Node<E> root, E key) {
        if (root == null || root.data.compareTo(key) == 0) {
            return root;
        }

        if (key.compareTo(root.data) < 0) {
            return searchRec(root.left, key);
        }

        return searchRec(root.right, key);
    }


    public boolean contains(E data) {
        return search(data) != null;
    }


    public int size() {
        return sizeRec(root);
    }

    private int sizeRec(Node<E> node) {
        if (node == null) {
            return 0;
        }
        return 1 + sizeRec(node.left) + sizeRec(node.right);
    }


    public List<E> inOrder() {
        List<E> elements = new ArrayList<>();
        inOrderRec(root, elements);
        return elements;
    }

    private void inOrderRec(Node<E> node, List<E> elements) {
        if (node != null) {
            inOrderRec(node.left, elements);
            elements.add(node.data);
            inOrderRec(node.right, elements);
        }
    }

    public List<E> inOrderDescending() {
        List<E> elements = new ArrayList<>();
        inOrderDescendingRec(root, elements);
        return elements;
    }

    private void inOrderDescendingRec(Node<E> node, List<E> elements) {
        if (node != null) {
            inOrderDescendingRec(node.right, elements);
            elements.add(node.data);
            inOrderDescendingRec(node.left, elements);
        }
    }

    protected Node<E> getRoot() {
        return root;
    }

    public boolean isEmpty() {
        return root == null;
    }
}