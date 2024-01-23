package algorithm;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathTest {

    @Test
    void gcdAndLcm() {
        Assertions.assertThat(MathUtil.gcdLoop(-1, 0)).isEqualTo(-1);
        Assertions.assertThat(MathUtil.gcdLoop(0, 0)).isEqualTo(0);
        Assertions.assertThat(MathUtil.gcdLoop(6, 8)).isEqualTo(2);
        Assertions.assertThat(MathUtil.gcdLoop(3, 3)).isEqualTo(3);

        Assertions.assertThat(MathUtil.lcm(6, 8)).isEqualTo(24);
    }

    @Test
    void gcdWithRecursion() {
        Assertions.assertThat(MathUtil.gcdRecursion(-1, 0)).isEqualTo(-1);
        Assertions.assertThat(MathUtil.gcdRecursion(0, 0)).isEqualTo(0);
        Assertions.assertThat(MathUtil.gcdRecursion(6, 8)).isEqualTo(2);
        Assertions.assertThat(MathUtil.gcdRecursion(3, 3)).isEqualTo(3);
    }

    @Test
    void basicCombination() {
        Assertions.assertThat(MathUtil.basicCombination(0, 0)).isEqualTo(1);
        Assertions.assertThat(MathUtil.basicCombination(1, 0)).isEqualTo(1);
        Assertions.assertThat(MathUtil.basicCombination(2, 1)).isEqualTo(2);
        Assertions.assertThat(MathUtil.basicCombination(8, 3)).isEqualTo(56);
    }

    @Test
    @DisplayName("주어지는 수 이하의 소수 개수를 구한다.")
    public void findPrimeNum () throws Exception {
        Assertions.assertThat(MathUtil.findPrimeNum(-3)).isEqualTo(-1);
        Assertions.assertThat(MathUtil.findPrimeNum(0)).isEqualTo(0);
        Assertions.assertThat(MathUtil.findPrimeNum(1)).isEqualTo(0);
        Assertions.assertThat(MathUtil.findPrimeNum(2)).isEqualTo(1);
        Assertions.assertThat(MathUtil.findPrimeNum(3)).isEqualTo(2);
        Assertions.assertThat(MathUtil.findPrimeNum(8)).isEqualTo(4);
        Assertions.assertThat(MathUtil.findPrimeNum(12)).isEqualTo(5);
        Assertions.assertThat(MathUtil.findPrimeNum(44)).isEqualTo(14);
    }

    @Test
    @DisplayName("Fibonacci를 계산하는 함수")
    public void fibonacci() throws Exception {
        Assertions.assertThat(MathUtil.fibonacciByFor(5)).isEqualTo(5);
        Assertions.assertThat(MathUtil.fibonacciByFor(6)).isEqualTo(8);
        Assertions.assertThat(MathUtil.fibonacciByFor(7)).isEqualTo(13);

        Assertions.assertThat(MathUtil.fibonacciByRec(5)).isEqualTo(5);
        Assertions.assertThat(MathUtil.fibonacciByRec(6)).isEqualTo(8);
        Assertions.assertThat(MathUtil.fibonacciByRec(7)).isEqualTo(13);

        Assertions.assertThat(MathUtil.fibonacciByDp(5)).isEqualTo(5);
        Assertions.assertThat(MathUtil.fibonacciByDp(6)).isEqualTo(8);
        Assertions.assertThat(MathUtil.fibonacciByDp(7)).isEqualTo(13);
    }
    
    @Test
    @DisplayName("주어진 정수의 각 자리 수의 합을 구한다.")
    public void sumEachNumber () throws Exception {
        Assertions.assertThat(MathUtil.sumEachNumber(0)).isEqualTo(0);
        Assertions.assertThat(MathUtil.sumEachNumber(100)).isEqualTo(1);
        Assertions.assertThat(MathUtil.sumEachNumber(235)).isEqualTo(10);
        Assertions.assertThat(MathUtil.sumEachNumber(235678)).isEqualTo(31);
        Assertions.assertThat(MathUtil.sumEachNumber(-1)).isEqualTo(1);
    }

    @Test
    @DisplayName("사다리를 한 칸 또는 두 칸씩 오를 수 있다고 했을 때 사다리 높이에 따른 사다리 오르기 방법의 경우의 수를 구한다.")
    public void ladder() throws Exception {
        Assertions.assertThat(MathUtil.ladder(0)).isEqualTo(1);
        Assertions.assertThat(MathUtil.ladder(1)).isEqualTo(1);
        Assertions.assertThat(MathUtil.ladder(2)).isEqualTo(2);
        Assertions.assertThat(MathUtil.ladder(3)).isEqualTo(3);
        Assertions.assertThat(MathUtil.ladder(4)).isEqualTo(5);
        Assertions.assertThat(MathUtil.ladder(5)).isEqualTo(8);
        Assertions.assertThat(MathUtil.ladder(6)).isEqualTo(13);
        Assertions.assertThat(MathUtil.ladder(7)).isEqualTo(21);
    }

    @Test
    @DisplayName("카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return")
    public void carpet() throws Exception {
        Assertions.assertThat(MathUtil.carpet(10, 2)).isEqualTo(new int[]{4,3});
        Assertions.assertThat(MathUtil.carpet(8, 1)).isEqualTo(new int[]{3,3});
        Assertions.assertThat(MathUtil.carpet(24, 24)).isEqualTo(new int[]{8,6});
    }

    @Test
    public void reduce() {
        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int result = numbers.reduce(Integer::sum).orElse(0); // 비어있으면 0반환
        assertEquals(55, result);
    }

    @Test
    public void longJump() {
        assertEquals(5, MathUtil.longJump(4));
        assertEquals(3, MathUtil.longJump(3));
    }
}
