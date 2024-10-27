package LinkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CP3LinkedListTest {

    @Test
    void size() {
        CP3LinkedList<Integer> list = new CP3LinkedList<>();
        assertEquals(0, list.size());
        list.addFirst(10);
        assertEquals(1, list.size());
    }

    @Test
    void contains() {
        CP3LinkedList<Integer> list = new CP3LinkedList<>();
        list.addFirst(10);
        assertTrue(list.contains(10));
        assertFalse(list.contains(-1));
    }

    @Test
    void addLast() {
        CP3LinkedList<Integer> list = new CP3LinkedList<>();
        list.addFirst(10);
        list.addLast(50);
        assertEquals(50, list.getLast());
    }
}