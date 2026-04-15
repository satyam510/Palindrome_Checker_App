import java.util.*;

interface PalindromeStrategy {
    boolean check(String input);
}

class StackStrategy implements PalindromeStrategy {

    public boolean check(String input) {

        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

class DequeStrategy implements PalindromeStrategy {

    public boolean check(String input) {

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : input.toCharArray()) {
            deque.add(c);
        }

        while (deque.size() > 1) {

            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }
}

public class UC12PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "level";

        PalindromeStrategy strategy = new StackStrategy();
        // You can switch to DequeStrategy like this:
        // PalindromeStrategy strategy = new DequeStrategy();

        boolean result = strategy.check(input);

        System.out.println("Input: " + input);
        System.out.println("Is Palindrome?: " + result);
    }
}