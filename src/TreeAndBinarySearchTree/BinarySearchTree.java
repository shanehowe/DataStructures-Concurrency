package TreeAndBinarySearchTree;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinarySearchTree<E extends Comparable<E>> {
    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(2);
        bst.insert(1);
        bst.insert(3);
        bst.insertIterative(4);
        bst.insertIterative(-1);
        bst.print();
        System.out.println(bst.contains(-1));
        System.out.println(bst.containsIterative(-1));
        System.out.println(bst.breadthFirstSearch(-1));
    }

    public boolean breadthFirstSearch(E element) {
        if (isEmpty()) return false;

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.data.compareTo(element) == 0) return true;
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return false;
    }

    public boolean containsIterative(E element) {
        Node head = root;
        while (head != null) {
            int comparisonResult = element.compareTo(head.data);
            if (comparisonResult == 0) return true;

            if (comparisonResult > 0) {
                head = head.right;
            } else {
                head = head.left;
            }
        }
        return false;
    }

    public boolean contains(E element) {
        return contains(root, element);
    }

    private boolean contains(Node root, E element) {
        if (root == null) return false;

        int comparisonResult = root.data.compareTo(element);

        if (comparisonResult == 0) return true;
        if (comparisonResult < 0) return contains(root.right, element);
        else return contains(root.left, element);
    }

    public void insert(E element) {
        Node newNode = new Node();
        newNode.data = element;
        newNode.left = null;
        newNode.right = null;
        if (root == null) root = newNode;
        else insertSub(newNode, root);
    }

    public void insertIterative(E element) {
        Node toInsert = new Node();
        toInsert.data = element;

        if (isEmpty()) {
            root = toInsert;
            return;
        }

        Node head = root;
        while (true) {
            int comparisonResult = toInsert.data.compareTo(head.data);
            if (comparisonResult >= 0) {
                if (head.right == null) {
                    head.right = toInsert;
                    return;
                }
                head = head.right;
            } else {
                if (head.left == null) {
                    head.left = toInsert;
                    return;
                }
                head = head.left;
            }
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    private void insertSub(Node newNode, Node node) {
        int result = newNode.data.compareTo(node.data);
        // duplicates go to the right
        if (result >= 0) {
            //go right
            if (node.right == null) {
                node.right = newNode;
            } else {
                insertSub(newNode, node.right);
            }
        } else {
            // go left
            if (node.left == null) {
                node.left = newNode;
            } else {
                insertSub(newNode, node.left);
            }
        }
    }

    public void print() {
        if (root != null) printSub(root);
    }

    private void printSub(Node node) {
        //inorder traversal
        if (node != null) {
            printSub(node.left);
            System.out.println(node.data);
            printSub(node.right);
        }
    }

    private class Node {
        public E data;
        public Node left;
        public Node right;
    }
}
