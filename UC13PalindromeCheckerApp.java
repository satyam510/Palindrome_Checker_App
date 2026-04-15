import java.util.*;

public class UC13PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "level";

        long startTime, endTime;

       
        startTime = System.nanoTime();

        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        boolean stackResult = true;

        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                stackResult = false;
                break;
            }
        }

        endTime = System.nanoTime();
        long stackTime = endTime - startTime;

        
        startTime = System.nanoTime();

        boolean twoPointerResult = true;
        int start = 0;
        int end = input.length() - 1;

        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                twoPointerResult = false;
                break;
            }
            start++;
            end--;
        }

        endTime = System.nanoTime();
        long twoPointerTime = endTime - startTime;

       
        System.out.println("Input: " + input);
        System.out.println("Is Palindrome?: " + (stackResult && twoPointerResult));

        System.out.println("Stack Approach Time : " + stackTime + " ns");
        System.out.println("Two Pointer Time    : " + twoPointerTime + " ns");
    }
}