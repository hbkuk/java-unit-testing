package algorithm;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RecursionUtilTest {

    @Test
    @DisplayName("N!을 출력하는 프로그램을 작성")
    public void factorial2() throws Exception {
        assertThat(RecursionUtil.factorial(10)).isEqualTo(3628800);
        assertThat(RecursionUtil.factorial(0)).isEqualTo(1);
    }

    @Test
    @DisplayName("n번째 피보나치 수를 구하는 프로그램을 작성")
    public void fibonacci() throws Exception {
        assertThat(RecursionUtil.fibonacci(10)).isEqualTo(55);
    }

    @Test
    @DisplayName("주어진 문자열이 팰린드롬인지 반환하는 프로그램 작성")
    public void isPalindrome() {
        assertThat(RecursionUtil.isPalindrome("AAA")).isTrue();
        assertThat(RecursionUtil.isPalindrome("ABBA")).isTrue();
        assertThat(RecursionUtil.isPalindrome("ABABA")).isTrue();
        assertThat(RecursionUtil.isPalindrome("ABCA")).isFalse();
        assertThat(RecursionUtil.isPalindrome("PALINDROME")).isFalse();
    }


}
