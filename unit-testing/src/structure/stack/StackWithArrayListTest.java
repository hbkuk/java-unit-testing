package structure.stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StackWithArrayListTest {

    @Test
    @DisplayName("ArrayList로 Stack 구현하기")
    public void stackWithArrayList() throws Exception {
        // given, when
        StackWithArrayList stack = new StackWithArrayList();

        // then
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        assertThat(stack.pop()).isEqualTo(6);
        assertThat(stack.pop()).isEqualTo(5);
        assertThat(stack.pop()).isEqualTo(4);
        assertThat(stack.pop()).isEqualTo(3);
        assertThat(stack.pop()).isEqualTo(2);
        assertThat(stack.pop()).isEqualTo(1);
        assertThat(stack.pop()).isEqualTo(0);
    }
}
