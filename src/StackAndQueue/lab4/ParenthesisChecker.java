package StackAndQueue.lab4;

import java.util.ArrayDeque;
import java.util.Deque;

public class ParenthesisChecker {

    public static boolean isBalanced(String expression) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : expression.toCharArray()) {
            String validParentheses = "()[]<>";
            if (!validParentheses.contains("" + c)) {
                continue;
            }
            if (isClosed(c)) {
                if (stack.isEmpty()) return false;
                else if (!areMatching(stack.pop(), c)) return false;
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    private static boolean isOpen(char paren) {
        return "([{<".contains("" + paren);
    }

    private static boolean isClosed(char paren) {
        return !isOpen(paren);
    }

    private static boolean areMatching(char open, char closed) {
        return (open == '(' && closed == ')') ||
                (open == '[' && closed == ']') ||
                (open == '{' && closed == '}') ||
                (open == '<' && closed == '>');
    }

    public static void main(String[] args) {
        System.out.println(isBalanced(""));
    }
}
