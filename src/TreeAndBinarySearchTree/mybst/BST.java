package TreeAndBinarySearchTree.mybst;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

public class BST<K extends Comparable<K>> implements Iterable<K> {

    private TreeNode root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public static void main(String[] args) {
        BST<Integer> set = new BST<>();
        System.out.println("Adding elements to the BST:");
        set.add(50);
        System.out.println("Added 50");
        set.add(25);
        System.out.println("Added 25");
        set.add(75);
        System.out.println("Added 75");
        set.add(12);
        System.out.println("Added 12");
        set.add(30);
        System.out.println("Added 30");
        set.add(60);
        System.out.println("Added 60");
        set.add(90);
        System.out.println("Added 90");
        set.add(55);
        System.out.println("Added 55");
        set.add(65);
        System.out.println("Added 65");

        System.out.println("BST elements in order:");
        set.iterator().forEachRemaining(System.out::println);

        System.out.println("Size: " + set.size());

        System.out.println("Removing element with one child (30):");
        set.remove(30);
        set.iterator().forEachRemaining(System.out::println);
        System.out.println("Size: " + set.size());

        System.out.println("Removing element with two children (75):");
        set.remove(75);
        set.iterator().forEachRemaining(System.out::println);
        System.out.println("Size: " + set.size());

    }

    public void add(K item) {
        root = add(item, root);
    }

    private TreeNode add(K item, TreeNode node) {
        if (node == null) {
            size++;
            return new TreeNode(item);
        }
        int comparison = item.compareTo(node.value);
        if (comparison < 0) {
            node.left = add(item, node.left);
        } else if (comparison > 0) {
            node.right = add(item, node.right);
        }
        return node;
    }

    public void clear() {
        root = null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public boolean contains(K item) {
        return contains(item, root);
    }

    private boolean contains(K item, TreeNode node) {
        if (node == null) {
            return false;
        }

        int comparison = item.compareTo(node.value);
        if (comparison == 0) {
            return true;
        } else if (comparison < 0) {
            return contains(item, node.left);
        } else {
            return contains(item, node.right);
        }
    }

    public void remove(K item) {
        if (isEmpty()) return;
        root = remove(item, root);
    }

    private TreeNode remove(K item, TreeNode node) {
        if (node == null) {
            return null;
        }
        int comparison = item.compareTo(node.value);
        if (comparison < 0) {
            node.left = remove(item, node.left);
        } else if (comparison > 0) {
            node.right = remove(item, node.right);
        } else {
            if (node.left == null && node.right == null) {
                decrementSize();
                return null;
            } else if (node.right == null) {
                decrementSize();
                return node.left;
            } else if (node.left == null) {
                decrementSize();
                return node.right;
            } else {
                TreeNode min = min(node.right);
                node.value = min.value;
                node.right = remove(min.value, node.right);
            }
        }
        return node;
    }

    private void decrementSize() {
        if (size == 0)
            return;
        size--;
    }

    private TreeNode min(TreeNode node) {
        if (node.left == null) return node;
        return min(node.left);
    }

    @Override
    public Iterator<K> iterator() {
        Queue<K> queue = new ArrayDeque<>();
        inorderIterator(root, queue);
        return queue.iterator();
    }

    private void inorderIterator(TreeNode node, Queue<K> queue) {
        if (node == null) {
            return;
        }
        inorderIterator(node.left, queue);
        queue.add(node.value);
        inorderIterator(node.right, queue);
    }

    private class TreeNode {
        private K value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(K value) {
            this.value = value;
        }
    }
}
