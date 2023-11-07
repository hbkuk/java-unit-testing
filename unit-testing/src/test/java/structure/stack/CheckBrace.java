package structure.stack;

import java.util.Stack;

public class CheckBrace {

    public static boolean checkBrace(String input) {
        char[] chars = input.trim().toCharArray();
        int openBracket = 0;

        // 양 끝단 괄호 체크
        if (chars[0] != '(' || chars[input.length() - 1] != ')') {
            return false;
        }

        // 안쪽 괄호 체크
        for (char ch : chars) {
            if (ch == '(') {
                openBracket++;
            }
            if (ch == ')') {
                openBracket--;
            }
        }

        return openBracket == 0;
    }

    public static boolean checkBraceWithStack(String input) {
        Stack<Character> stack = new Stack<>();

        char[] chars = input.trim().toCharArray();

        // 양 끝단 괄호 체크
        if (chars.length == 0 || chars[0] != '(' || chars[input.length() - 1] != ')') {
            return false;
        }

        for (char ch : chars) {
            if(ch == '(') {
                stack.push(ch);
            }
        }

        for(char ch : chars) {
            if(ch == ')') {
                if(stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
