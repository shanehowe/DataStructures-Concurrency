package Recursion.lab4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecursionTest {

    @Test
    void factorial() {
        assertEquals(120, Recursion.factorial(5));
    }

    @Test
    void sum() {
        assertEquals(8, Recursion.sum(new int[] {1,1,1,1,1,1,1,1}));
    }

    @Test
    void fib() {
        assertEquals(21, Recursion.fib(8));
    }
}