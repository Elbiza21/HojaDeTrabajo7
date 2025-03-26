package Main.Java;
public class BST<E extends Comparable<E>> {
    private Node<E> root;

    public static class Node<E> {
        E data;
        Node<E> left, right;

        public Node(E data) {
            this.data = data;
        }
    }

    protected Node<E> getRoot() {
        return root;
    }
    public BST() {
        root = null;
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

    public void inOrderTraversal() {
        inOrderRec(root);
    }

    private void inOrderRec(Node<E> root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.data);
            inOrderRec(root.right);
        }
    }

    public void inOrderTraversalDescending() {
        inOrderDescendingRec(root);
    }

    private void inOrderDescendingRec(Node<E> root) {
        if (root != null) {
            inOrderDescendingRec(root.right);
            System.out.println(root.data);
            inOrderDescendingRec(root.left);
        }
    }
    public int size() {
        return sizeRec(root);
    }

    private int sizeRec(Node<E> node) {
        if (node == null) return 0;
        return 1 + sizeRec(node.left) + sizeRec(node.right);
    }

    public boolean contains(E data) {
        return search(data) != null;
    }


}