package Matcher;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MatcherTest {

    @Test
    @DisplayName("패턴 클래스의 matches 메서드()를 통해서 정규식과 입력값을 비교")
    void coordinate_custom_regex_test() {
        // given
        String regex = "\\((\\d+),(\\d+)\\)";

        //when
        boolean actual = Pattern.matches(regex, "(100,300)");

        //then
        assertThat(actual).isTrue();
    }

    @Test
    @DisplayName("패턴 클래스의 compile() 메서드를 통해 최초 1회 Matcher 클래스를 만들고, 이후 입력값과 비교")
    void coordinate_custom_regex_test2() {
        // given
        Pattern pattern = Pattern.compile("\\((\\d+),(\\d+)\\)");

        //when
        Matcher matcher = pattern.matcher("(100,300)");

        //then
        assertThat(matcher.find()).isEqualTo(true);
    }


    @ParameterizedTest
    @CsvSource(value = {"(1,3):true", "(100,300):true", "(1,2:false", "1,3):false", "1,2:false"}, delimiter = ':')
    @DisplayName("정규식을 통해 검증하고, 입력값에 따른 기대값이 맞는지 확인")
    void coordinate_custom_regex_test3(String input, Boolean expected) {
        // given
        Pattern pattern = Pattern.compile("\\((\\d+),(\\d+)\\)");

        //when
        Matcher matcher = pattern.matcher(input);

        //then
        assertThat(matcher.find()).isEqualTo(expected);
    }

    @Test
    @DisplayName("matcher.group() 메서드를 활용한 정규식과 일치하는 문자열 그룹을 확인")
    void group_test() {
        // given
        String input = "입력하신 좌표는 (1,2) 입니다.";
        Pattern pattern = Pattern.compile("\\((\\d+),(\\d+)\\)");

        //when
        Matcher matcher = pattern.matcher(input);

        //then
        assertThat(matcher.find()).isTrue();
        assertThat(matcher.group()).isEqualTo("(1,2)");
    }
    
    @Test
    @DisplayName("matcher.group(int group) 메서드를 활용한 정규식과 일치하는 문자열 그룹을 확인")
    void group_test2() {
        // given
        String input = "입력하신 좌표는 (50,60) 입니다.";
        Pattern pattern = Pattern.compile("\\((\\d+),(\\d+)\\)");

        //when
        Matcher matcher = pattern.matcher(input);

        //then
        assertThat(matcher.find()).isTrue();
        assertThat(matcher.group(1)).isEqualTo("50");
        assertThat(matcher.group(2)).isEqualTo("60");
    }
}
