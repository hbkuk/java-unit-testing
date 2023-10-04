package algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MathTest {

    @Test
    void gcdAndGcm() {
        assertThat(MathUtil.gcd(-1, 0)).isEqualTo(-1);
        assertThat(MathUtil.gcd(0, 0)).isEqualTo(0);
        assertThat(MathUtil.gcd(6, 8)).isEqualTo(2);
        assertThat(MathUtil.gcd(3, 3)).isEqualTo(3);

        assertThat(MathUtil.lcm(6, 8)).isEqualTo(24);
    }
}
