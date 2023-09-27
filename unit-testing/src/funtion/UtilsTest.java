package funtion;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @ParameterizedTest
    @CsvSource(value = {"1:2", "5:10", "50:100"}, delimiter = ':')
    void multiplyByTwo(int number, int result) {
        // given
        Function<Integer, Integer> multiplyByTwo = x -> x * 2;

        //when
        int acture = multiplyByTwo.apply(number);

        //thenm
        assertEquals(acture, result);
    }

    @Test
    @DisplayName("stream() API를 활용한 모든 짝수의 합을 반환")
    void sum_of_even_numbers1() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //when
        int sumEvenNumbers = numbers.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();

        //then
        assertEquals(sumEvenNumbers, 30);
    }

    @Test
    @DisplayName("Funtion API를 활용한 모든 짝수의 합을 반환")
    void sum_of_even_numbers2() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //when
        Function<List<Integer>, Integer> sumEvenNumbers = nums -> {
            return nums.stream()
                        .filter(number -> number % 2 == 0)
                        .mapToInt(Integer::intValue)
                        .sum();
        };

        //then
        assertEquals(sumEvenNumbers.apply(numbers), 30);
    }

    @Test
    @DisplayName("문자열 목록을 입력받고, 모든 문자열의 길이를 반환")
    void sum_of_all_String_length() {
        // given
        List<String> fruits = Arrays.asList("apple", "peach", "waterMelon", "strawberry");

        //when
        Function<List<String>, Integer> sumStringLength = strings -> {
            return strings.stream()
                    .map(value -> value.length())
                    .mapToInt(Integer::intValue)
                    .sum();
        };

        //then
        assertEquals(sumStringLength.apply(fruits), 30);
    }

    @Test
    @DisplayName("문자열 목록을 입력받고, 모든 문자열의 길이 리스트를 반환")
    void string_length_list() {
        // given
        List<String> fruits = Arrays.asList("apple", "peach", "waterMelon", "strawberry");

        //when
        Function<List<String>, List<Integer>> stringLengthList = strings -> {
            return strings.stream()
                    .map(value -> value.length())
                    .collect(Collectors.toList());
        };

        //then
        assertEquals(stringLengthList.apply(fruits), Arrays.asList(5, 5, 10, 10));
    }

    @Test
    @DisplayName("정수 목록을 입력으로 받아 목록의 최대값을 반환")
    void find_max_value() {
        // given
        List<Integer> numbers = Arrays.asList(100, 10, 500, 1000, 30, 0, -1, 400);

        // when
        Function<List<Integer>, Integer> find_max_value = nums -> {
            return nums.stream()
                    .mapToInt(x -> x)
                    .max()
                    .orElseThrow(NoSuchElementException::new);
        };

        // then
        assertEquals( find_max_value.apply(numbers), 1000);
    }

    @Test
    @DisplayName("문자열 목록을 입력으로 받아 소문자 's'로 시작하는 모든 문자열 목록을 반환")
    void find_startswith_s() {
        // given
        List<String> fruits = Arrays.asList("apple", "peach", "waterMelon", "strawberry","sugarApple");

        // when
        BiFunction<List<String>, String, List<String>> find_startswith_s = (strings, targetString) -> {
            return strings.stream()
                        .filter(string -> string.toLowerCase().startsWith(targetString.toLowerCase()))
                        .collect(Collectors.toList());
        };

        // then
        assertThat(find_startswith_s.apply(fruits, "s"))
                    .contains("strawberry")
                    .contains("sugarApple")
                    .doesNotContain("apple");
    }
}