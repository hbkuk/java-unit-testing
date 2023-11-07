package algorithm;

public class RecursionUtil {

    public static Long factorial(int number) {
        if (number <= 1) {
            return 1L;
        }
        return number * factorial(number - 1);
    }

    public static int fibonacci(int number) {
        if (number <= 1) {
            return number;
        }
        return fibonacci(number - 1) + fibonacci(number - 2);
    }

    public static boolean isPalindrome(String input) {
        int inputLength = input.length();
        if (inputLength <= 1) {
            return true;
        }

        String inputString = input.trim().toLowerCase();
        // 짝수
        return isPalindromeRecursive(inputString, 0, inputLength - 1);
    }

    private static boolean isPalindromeRecursive(String inputString, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (inputString.charAt(left) != inputString.charAt(right)) {
            return false;
        }
        return isPalindromeRecursive(inputString, left + 1, right - 1);
    }
}
