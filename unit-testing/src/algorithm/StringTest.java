package algorithm;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringTest {

    @Test
    @DisplayName("주어진 문자열을 int 형으로 변환한다")
    void toIntFromString() {
        assertThat(StringUtil.toIntFromString("123")).isEqualTo(123);
    }

    @Test
    @DisplayName("주어진 문자열을 역순으로 출력한다")
    void reverseString() {
        assertThat(StringUtil.reverseString("abc")).isEqualTo("cba");
        assertThat(StringUtil.reverseString("abcd")).isEqualTo("dcba");
    }

    @Test
    @DisplayName("주어진 문자열에서 문자열을 구성하고 있는 각각의 문자열들이 고유한지를 판단한다")
    void UniqueCharacterInString() {
        assertThat(StringUtil.uniqueCharacterInString("abcd")).isTrue();
        assertThat(StringUtil.uniqueCharacterInString("abcdefghij")).isTrue();
        assertThat(StringUtil.uniqueCharacterInString("abccde")).isFalse();
        assertThat(StringUtil.uniqueCharacterInString("abca")).isFalse();
    }
}
