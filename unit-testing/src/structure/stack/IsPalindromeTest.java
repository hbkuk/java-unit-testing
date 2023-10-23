package structure.stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static structure.stack.IsPalindrome.isPalindrome;

public class IsPalindromeTest {

    @Test
    @DisplayName("Stack 자료구조를 사용하여 회문을 판별한다.")
    public void isPalindromeTest() throws Exception {
        assertTrue(isPalindrome("abba"));
        assertTrue(isPalindrome("dabccbad"));
        assertTrue(isPalindrome("abcba"));
        assertTrue(isPalindrome("fabccdedccbaf"));
        assertFalse(isPalindrome("fabccdedccbf"));
    }
}
