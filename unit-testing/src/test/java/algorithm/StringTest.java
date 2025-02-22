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
    void uniqueCharacterInString() {
        assertThat(StringUtil.uniqueCharacterInString("abcd")).isTrue();
        assertThat(StringUtil.uniqueCharacterInString("abcdefghij")).isTrue();
        assertThat(StringUtil.uniqueCharacterInString("abccde")).isFalse();
        assertThat(StringUtil.uniqueCharacterInString("abca")).isFalse();
    }

    @Test
    @DisplayName("주어진 문자열이 애너그램인지를 판단한다")
    void isAnagram() {
        assertThat(StringUtil.isAnagram("arc", "car")).isTrue();
        assertThat(StringUtil.isAnagram("caaabbb", "abababc")).isTrue();
        assertThat(StringUtil.isAnagram("caabbbb", "abababc")).isFalse();
        assertThat(StringUtil.isAnagram("arc", "carr")).isFalse();
        assertThat(StringUtil.isAnagram("arc", "caz")).isFalse();
    }

    @Test
    @DisplayName("주어진 문자열을 길이와 함께 적어주면서 압축을 한다")
    void characterCompressWithLength() {
        assertThat(StringUtil.characterCompressWithLength(null)).isNull();
        assertThat(StringUtil.characterCompressWithLength("aaabbbccc")).isEqualTo("a3b3c3");
        assertThat(StringUtil.characterCompressWithLength("aabbacbccc")).isEqualTo("a3b3c4");
        assertThat(StringUtil.characterCompressWithLength("aaabbbccc")).isEqualTo("a3b3c3");
    }

    @Test
    @DisplayName("주어진 문서(단어별로 나뉘어진 배열)에서 특정 단어의 빈도를 구한다")
    void frequencyStringInDocument() {
        String[] strArr = new String[100];
        assertThat(StringUtil.frequencyStringInDocument(strArr, null)).isEqualTo(0);

        strArr[0] = "jbee";
        assertThat(StringUtil.frequencyStringInDocument(strArr, "jbee")).isEqualTo(1);

        strArr[1] = "jbee";
        assertThat(StringUtil.frequencyStringInDocument(strArr, "jbee")).isEqualTo(2);

        strArr[2] = "jbee";
        assertThat(StringUtil.frequencyStringInDocument(strArr, "jbee")).isEqualTo(3);
    }

    @Test
    @DisplayName("올바른 괄호 문자열인지 확인한다.")
    void correctString() {
        assertThat(StringUtil.correctString("[](){}")).isEqualTo(3);
        assertThat(StringUtil.correctString("}]()[{")).isEqualTo(2);
        assertThat(StringUtil.correctString("[)(]")).isEqualTo(0);
        assertThat(StringUtil.correctString("}}}")).isEqualTo(0);
    }

    @Test
    void saleProductTest() {
        assertThat(StringUtil.saleProduct(new String[]{"banana", "apple", "rice", "pork", "pot"}, new int[]{3, 2, 2, 2, 1}, new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"})).isEqualTo(3);
    }
}
