package structure.stack;

import java.util.Stack;

public class IsPalindrome {

    public static boolean isPalindrome(String input) {
        Stack<Character> stack = new Stack<>();

        input = input.toLowerCase().trim();
        input = input.replaceAll("[^a-z]", "");

        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : input.toCharArray()) {
            if (stack.pop() != ch) {
                return false;
            }
        }
        return true;
    }
}
