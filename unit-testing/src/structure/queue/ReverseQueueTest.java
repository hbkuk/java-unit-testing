package structure.queue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseQueueTest {

    @Test
    @DisplayName("Stack을 사용하여 queue를 stack처럼 만든다.")
    public void reverseQueue() throws Exception {
        Queue<Integer> que = new LinkedList<>();
        que.offer(1);
        que.offer(2);
        que.offer(3);

        reverseQueue(que);

        assertEquals(3, que.poll());
        assertEquals(2, que.poll());
        assertEquals(1, que.poll());
    }

    public Queue<Integer> reverseQueue(Queue<Integer> que) {
        Stack<Integer> stack = new Stack<>();
        while( !que.isEmpty() ) {
            stack.push(que.poll());
        }
        while( !stack.isEmpty()) {
            que.offer(stack.pop());
        }
        return que;
    }
}
