package lambda;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class streamTest {
    
    @Test
    @DisplayName("reduce는 모든 요소를 하나로 줄이는데 사용, Optional 반환하므로 orElse() 혹은 orElseGet() 메서드 사용")
    public void reduce1() {
        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int result = numbers.reduce(Integer::sum).orElse(0); // 비어있으면 0반환
        assertEquals(55, result);
    }

    @Test
    @DisplayName("초기값이 있는 Stream.reduce 메서드")
    public void reduce2() {
        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int result = numbers.reduce(10, (total, n) -> total + n);
        assertEquals(65, result);
    }
}
