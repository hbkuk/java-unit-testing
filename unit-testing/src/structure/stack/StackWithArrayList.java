package structure.stack;

import java.util.ArrayList;

public class StackWithArrayList {

    public final ArrayList<Integer> arrayList;

    public StackWithArrayList() {
        this.arrayList = new ArrayList<>();
    }

    public void push(int item) {
        arrayList.add(item);
    }

    public int pop() {
        return arrayList.remove(getLastIndex());
    }

    private int getLastIndex() {
        return arrayList.size() - 1;
    }
}
