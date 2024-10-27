package LinkedList;

import java.util.NoSuchElementException;

/**
 * A linked list is a sequence of links with efficient
 * element insertion and removal. This class
 * contains a subset of the methods of the standard
 * java.util.LinkedList class.
 */

public class CP3LinkedList<E> {
    private Node first;
    private Node last;
    private int size;

    /**
     * Constructs an empty linked list.
     */
    public CP3LinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Adds an element to the front of the linked list.
     *
     * @param element the element to add
     */
    public void addFirst(E element) {
        Node newLink = new Node();
        newLink.data = element;
        newLink.next = first;
        if (first != null) {
            first.prev = newLink;
        } else {
            last = newLink;
        }
        first = newLink;
        incrementSize();
    }

    public E getFirst() {
        if (first == null) throw new NoSuchElementException();
        return first.data;
    }

    public E removeFirst() {
        if (first == null) throw new NoSuchElementException();
        E element = first.data;
        first = first.next;
        if (first != null) {
            first.prev = null;
        } else {
            last = null;
        }
        decrementSize();
        return element;
    }

    public void addLast(E value) {
        Node newLastNode = new Node();
        newLastNode.data = value;
        if (size() == 0) {
            first = newLastNode;
        } else {
            last.next = newLastNode;
            newLastNode.prev = last;
        }
        last = newLastNode;
        incrementSize();
    }

    public E getLast() {
        if (last == null) throw new NoSuchElementException();
        return last.data;
    }

    public int size() {
        return size;
    }

    private void decrementSize() {
        if (size == 0)
            return;
        size--;
    }

    private void incrementSize() {
        size++;
    }

    public boolean contains(E value) {
        if (size() == 0) {
            return false;
        }

        for (Node n = first; n != null; n = n.next) {
            if (n.data.equals(value)) {
                return true;
            }
        }

        return false;
    }

    public void print() {
        //outputs the data on the list
        Node current = first;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    private class Node {
        public E data;
        public Node next;
        public Node prev;
    }
}