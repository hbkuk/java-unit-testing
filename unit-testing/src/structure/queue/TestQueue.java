package structure.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class Queue<T> {

    class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    Node<T> first;
    Node<T> last;

    public void add(T data) {
        Node<T> newNode = new Node<>(data);

        if (first == null) {
            first = newNode;
        }

        if (last == null) {
            last = newNode;
        }
        if (last != null) {
            last.next = newNode;
            last = newNode;
        }
    }

    public T remove() {
        if(first == null) {
            throw new NoSuchElementException();
        }
        Node<T> target = first;
        first = target.next;

        if(first == null) {
            last = null;
        }
        return target.data;
    }

    public T peek() {
        if(first == null) {
            throw new NoSuchElementException();
        }
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }
}

public class TestQueue {

    private Queue<Integer> queue;

    @BeforeEach
    public void setUp() {
        queue = new Queue<>();
    }

    @Test
    public void testAddAndPeek() {
        queue.add(1);
        assertEquals(Integer.valueOf(1), queue.peek());
        queue.add(2);
        assertEquals(Integer.valueOf(1), queue.peek());
        queue.add(3);
        assertEquals(Integer.valueOf(1), queue.peek());
    }

    @Test
    public void testRemove() {
        queue.add(1);
        queue.add(2);
        queue.add(3);
        assertEquals(Integer.valueOf(1), queue.remove());
        assertEquals(Integer.valueOf(2), queue.remove());
        assertEquals(Integer.valueOf(3), queue.remove());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(queue.isEmpty());
        queue.add(1);
        assertFalse(queue.isEmpty());
    }

}
