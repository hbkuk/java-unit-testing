package structure.stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumStackTest {

    @Test
    @DisplayName("Stack에 저장된 값들 중 최소 값을 반환하는 minStack() 함수 구현")
    public void minimumStack() throws Exception {
        MinimumStack stack = new MinimumStack();
        stack.push(3);
        stack.push(5);
        stack.push(4);
        stack.push(2);
        stack.push(6);

        assertEquals(2, stack.min());
    }
}
