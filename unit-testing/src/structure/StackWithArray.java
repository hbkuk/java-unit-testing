package structure;

public class StackWithArray {

    private int[] array;
    private int top;

    public StackWithArray() {
        this.array = new int[8];
        this.top = -1;
    }

    public void push(int item) {
        // 공간 확인
        if (top == array.length - 1) {
            int[] widerArray = new int[array.length * 2];

            for (int i = 0; i <= top; i++) {
                widerArray[i] = array[i];
            }
            array = widerArray;
        }
        top++;
        array[top] = item;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        int item = array[top];
        top--;
        return item;
    }

    private boolean isEmpty() {
        return top < 0;
    }
}
