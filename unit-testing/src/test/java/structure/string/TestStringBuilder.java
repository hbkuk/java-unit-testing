package structure.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringBuilder {
    private static final int INITIAL_ARRAY_CAPACITY = 1;
    private static final int ARRAY_EXPAND_FACTOR = 2;
    private char[] array;
    private int size;
    private int index;

    public StringBuilder() {
        size = INITIAL_ARRAY_CAPACITY;
        array = new char[size];
        index = 0;
    }

    public void append(String data) {
        if (data == null) {
            data = "null";
        }
        char[] chars = data.toCharArray();
        int spareSpace = size - index;
        if (spareSpace < chars.length) {
            array = doubling(chars.length - spareSpace);
        }
        appendData(chars);
    }

    private void appendData(char[] newChars) {
        for (int i = 0; i < newChars.length; i++) {
            array[index] = newChars[i];
            index++;
        }
    }

    private char[] doubling(int requiredMinCapacity) {
        size = size + (requiredMinCapacity * ARRAY_EXPAND_FACTOR);

        char[] newChars = new char[size];
        for (int i = 0; i <= index; i++) {
            newChars[i] = array[i];
        }

        return newChars;
    }

    public String toString() {
        return new String(array, 0, index);
    }
}

public class TestStringBuilder {

    @Test
    void create() {
        StringBuilder stringBuilder = new StringBuilder();
    }

    @Test
    void append() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("item 1");
        stringBuilder.append("item 2");
        stringBuilder.append("item 3");
    }

    @Test
    void appendAndToString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("item 1");
        stringBuilder.append("\n");
        stringBuilder.append("item 2");
        stringBuilder.append("\n");
        stringBuilder.append("item 3");

        assertEquals("item 1\nitem 2\nitem 3", stringBuilder.toString());
    }
}
