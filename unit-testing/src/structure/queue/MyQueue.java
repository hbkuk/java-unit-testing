package structure.queue;

import java.util.Stack;

public class MyQueue<T> {

    private final Stack<T> inStack;
    private final Stack<T> outStack;

    public MyQueue() {
        this.inStack = new Stack<T>();
        this.outStack = new Stack<T>();
    }

    public void offer(T item) {
        inStack.push(item);
    }


    public int size() {
        return inStack.size();
    }

    public T poll() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }

        if (outStack.isEmpty()) {
            throw new IndexOutOfBoundsException("비어있어요");
        }

        return outStack.pop();
    }
}
