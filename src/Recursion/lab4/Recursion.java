package Recursion.lab4;

import java.util.HashMap;
import java.util.Map;

public class Recursion {

    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static int sum(int[] nums) {
        return sum(nums, 0);
    }

    private static int sum(int[] nums, int index) {
        if (index == nums.length) {
            return 0;
        }
        return nums[index] + sum(nums, index + 1);
    }

    public static long fib(int n) {
        return fib(n, new HashMap<>());
    }

    private static long fib(long n, Map<Long, Long> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        memo.put(n, fib(n - 1, memo) + fib(n - 2, memo));
        return memo.get(n);
    }
}
