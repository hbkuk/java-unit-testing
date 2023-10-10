package algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MathTest {

    @Test
    void gcdAndLcm() {
        assertThat(MathUtil.gcd(-1, 0)).isEqualTo(-1);
        assertThat(MathUtil.gcd(0, 0)).isEqualTo(0);
        assertThat(MathUtil.gcd(6, 8)).isEqualTo(2);
        assertThat(MathUtil.gcd(3, 3)).isEqualTo(3);

        assertThat(MathUtil.lcm(6, 8)).isEqualTo(24);
    }

    @Test
    void basicCombination() {
        assertThat(MathUtil.basicCombination(0, 0)).isEqualTo(1);
        assertThat(MathUtil.basicCombination(1, 0)).isEqualTo(1);
        assertThat(MathUtil.basicCombination(2, 1)).isEqualTo(2);
        assertThat(MathUtil.basicCombination(8, 3)).isEqualTo(56);
    }

    @Test
    void findPrimeNumTest() {
        assertThat(MathUtil.findPrimeNumTest(-3)).isEqualTo(-1);
        assertThat(MathUtil.findPrimeNumTest(0)).isEqualTo(0);
        assertThat(MathUtil.findPrimeNumTest(1)).isEqualTo(0);
        assertThat(MathUtil.findPrimeNumTest(2)).isEqualTo(1);
        assertThat(MathUtil.findPrimeNumTest(3)).isEqualTo(2);
        assertThat(MathUtil.findPrimeNumTest(8)).isEqualTo(4);
        assertThat(MathUtil.findPrimeNumTest(12)).isEqualTo(5);
        assertThat(MathUtil.findPrimeNumTest(44)).isEqualTo(14);
    }
}
