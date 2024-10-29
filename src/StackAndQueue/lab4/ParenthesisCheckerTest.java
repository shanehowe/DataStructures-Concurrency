package StackAndQueue.lab4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParenthesisCheckerTest {

    @Test
    void isBalanced() {
        assertTrue(ParenthesisChecker.isBalanced("(4+4) * [1+(6 * 6)]"));
        assertFalse(ParenthesisChecker.isBalanced("(4+4) * [1+(6 * 6)](()"));
        assertTrue(ParenthesisChecker.isBalanced(""));
    }
}