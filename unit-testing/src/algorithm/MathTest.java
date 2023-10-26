package algorithm;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MathTest {

    @Test
    void gcdAndLcm() {
        assertThat(MathUtil.gcdLoop(-1, 0)).isEqualTo(-1);
        assertThat(MathUtil.gcdLoop(0, 0)).isEqualTo(0);
        assertThat(MathUtil.gcdLoop(6, 8)).isEqualTo(2);
        assertThat(MathUtil.gcdLoop(3, 3)).isEqualTo(3);

        assertThat(MathUtil.lcm(6, 8)).isEqualTo(24);
    }

    @Test
    void gcdWithRecursion() {
        assertThat(MathUtil.gcdRecursion(-1, 0)).isEqualTo(-1);
        assertThat(MathUtil.gcdRecursion(0, 0)).isEqualTo(0);
        assertThat(MathUtil.gcdRecursion(6, 8)).isEqualTo(2);
        assertThat(MathUtil.gcdRecursion(3, 3)).isEqualTo(3);
    }

    @Test
    void basicCombination() {
        assertThat(MathUtil.basicCombination(0, 0)).isEqualTo(1);
        assertThat(MathUtil.basicCombination(1, 0)).isEqualTo(1);
        assertThat(MathUtil.basicCombination(2, 1)).isEqualTo(2);
        assertThat(MathUtil.basicCombination(8, 3)).isEqualTo(56);
    }

    @Test
    @DisplayName("주어지는 수 이하의 소수 개수를 구한다.")
    public void findPrimeNum () throws Exception {
        assertThat(MathUtil.findPrimeNum(-3)).isEqualTo(-1);
        assertThat(MathUtil.findPrimeNum(0)).isEqualTo(0);
        assertThat(MathUtil.findPrimeNum(1)).isEqualTo(0);
        assertThat(MathUtil.findPrimeNum(2)).isEqualTo(1);
        assertThat(MathUtil.findPrimeNum(3)).isEqualTo(2);
        assertThat(MathUtil.findPrimeNum(8)).isEqualTo(4);
        assertThat(MathUtil.findPrimeNum(12)).isEqualTo(5);
        assertThat(MathUtil.findPrimeNum(44)).isEqualTo(14);
    }
}
