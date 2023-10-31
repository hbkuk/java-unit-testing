package structure.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class Stack<T> {
    Node<T> top;

    class Node<T> {
        T data;
        Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    public T pop() {
        if(top == null) {
            throw new EmptyStackException();
        }
        Node<T> target = top;
        top = top.next;
        return target.data;
    }

    public void push(T data) {
        Node<T> newNode = new Node<>(data, top);
        top = newNode;
    }

    public T peek() {
        if(top == null) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

public class TestStack {

    private Stack<Integer> stack;

    @BeforeEach
    public void setUp() {
        stack = new Stack<>();
    }

    @Test
    public void testPushAndPeek() {
        stack.push(1);
        assertEquals(Integer.valueOf(1), stack.peek());
        stack.push(2);
        assertEquals(Integer.valueOf(2), stack.peek());
        stack.push(3);
        assertEquals(Integer.valueOf(3), stack.peek());
    }

    @Test
    public void testPop() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(Integer.valueOf(3), stack.pop());
        assertEquals(Integer.valueOf(2), stack.pop());
        assertEquals(Integer.valueOf(1), stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
    }
}
