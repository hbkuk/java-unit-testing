package structure.stack;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMultiStack {

    @Test
    void createFixedMultiStack() {
        FixedMultiStacks multiStacks = new FixedMultiStacks(3);
    }

    @Test
    void isEmpty() {
        FixedMultiStacks multiStacks = new FixedMultiStacks(3);
        assertThat(multiStacks.isEmpty(0)).isTrue();
        assertThat(multiStacks.isEmpty(1)).isTrue();
        assertThat(multiStacks.isEmpty(2)).isTrue();
    }

    @Test
    void push() throws FullStackException {
        FixedMultiStacks multiStacks = new FixedMultiStacks(3);
        multiStacks.push(0, 3);

        assertEquals(multiStacks.isEmpty(0), false);
    }

    @Test
    void push_throw_full_stack_exception() throws FullStackException {
        FixedMultiStacks multiStacks = new FixedMultiStacks(3);
        multiStacks.push(1, 3);
        multiStacks.push(1, 4);
        multiStacks.push(1, 4);

        assertThatExceptionOfType(FullStackException.class)
                .isThrownBy(() -> {
                    multiStacks.push(1, 4);
                });
    }

    @Test
    void pop() throws FullStackException {
        FixedMultiStacks multiStacks = new FixedMultiStacks(3);
        multiStacks.push(0, 3);
        multiStacks.push(0, 4);

        assertEquals(4, multiStacks.pop(0));
        assertEquals(3, multiStacks.pop(0));
    }

    @Test
    void peek() throws FullStackException {
        FixedMultiStacks multiStacks = new FixedMultiStacks(3);
        multiStacks.push(1, 3);
        multiStacks.push(1, 4);
        multiStacks.push(1, 5);

        assertTrue(multiStacks.isFull(1));
        assertEquals(5, multiStacks.peek(1));
        assertTrue(multiStacks.isFull(1));
    }
}

class FixedMultiStacks {
    private int numOfStacks = 3;
    private int stackSize;
    private int[] values;
    private int[] sizes;

    public FixedMultiStacks(int stackSize) {
        this.stackSize = stackSize;
        this.values = new int[numOfStacks * stackSize];
        this.sizes = new int[numOfStacks];
    }

    public boolean isEmpty(int stackNumber) {
        return this.sizes[stackNumber] == 0;
    }

    public boolean isFull(int stackNumber) {
        return this.sizes[stackNumber] == stackSize;
    }

    public int getTopIndex(int stackNumber) {
        int offset = stackSize * stackNumber - 1;
        int index = sizes[stackNumber];
        return offset + index;
    }

    public void push(int stackNum, int data) throws FullStackException {
        if (isFull(stackNum)) {
            throw new FullStackException();
        }

        values[getTopIndex(stackNum) + 1] = data;
        sizes[stackNum]++;
    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        int topIdx = getTopIndex(stackNum);
        int topIdxItem = values[topIdx];

        values[topIdx] = 0;
        sizes[stackNum]--;

        return topIdxItem;
    }

    public int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }

        return values[getTopIndex(stackNum)];
    }
}

class FullStackException extends Exception {
    public FullStackException() {
        super();
    }

    public FullStackException(String msg) {
        super(msg);
    }
}