package Recursion.lab4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchRecursiveTest {

    final int[] nums = {1,2,3,4,5,6,7,8,9,10,11};

    @Test
    void searchReturnsMinusOneWhenTargetIsNotInArray() {
        assertEquals(-1, BinarySearchRecursive.search(nums, 100));
    }

    @Test
    void searchReturnsCorrectIndexWhenTargetIsInArray() {
        assertEquals(0, BinarySearchRecursive.search(nums, 1));
        assertEquals(10, BinarySearchRecursive.search(nums, 11));
        assertEquals(2, BinarySearchRecursive.search(nums, 3));
    }
}