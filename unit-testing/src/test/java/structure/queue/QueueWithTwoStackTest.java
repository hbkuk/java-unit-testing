package structure.queue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueueWithTwoStackTest {

    @Test
    @DisplayName("Stack 두 개로 Queue 구현")
    public void queueWithTwoStack() throws Exception {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);

        assertEquals(queue.size(), 4);

        assertEquals(queue.poll(), 1);
        assertEquals(queue.poll(), 2);
        assertEquals(queue.poll(), 3);
        assertEquals(queue.poll(), 4);

        assertEquals(queue.size(), 0);
    }
}
