package structure.stack;

import java.util.Stack;

public class MinimumStack {

    private final Stack<Integer> stack;
    private final Stack<Integer> minStack;

    public MinimumStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }
    public void push(int item) {
        if(minStack.isEmpty() || minStack.peek() >= item) {
            minStack.push(item);
        }
        stack.push(item);
    }
    public int pop() {
        int value = stack.pop();
        if(!minStack.isEmpty() && value == minStack.peek()) {
            minStack.pop();
        }
        return value;
    }
    public int min() {
        if(minStack.isEmpty()) {
            throw new RuntimeException();
        }
        return minStack.peek();
    }
}
