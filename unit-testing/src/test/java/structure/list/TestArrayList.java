package structure.list;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayList<E> {
    private static final int INITIAL_CAPACITY = 3;
    private static final int ARRAY_GROWTH_FACTOR = 2;
    private E[] data;
    private int size;
    private int index;

    public ArrayList() {
        this.size = INITIAL_CAPACITY;
        this.data = (E[]) new Object[size];
        this.index = -1;
    }

    public int size() {
        return size;
    }

    public int getIndex() {
        return index;
    }

    public void add(E item) {
        index++;
        if (isFull()) {
            data = expandCapacity();
        }
        data[index] = item;
    }

    public E get(int index) {
        validateIndex(index);
        return data[index];
    }

    private void validateIndex(int index) {
        if (this.index < index) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (index < 0) {
            throw new IllegalArgumentException();
        }
    }

    private E[] expandCapacity() {
        size = size * ARRAY_GROWTH_FACTOR;
        E[] newList = (E[]) new Object[size];
        copyDataNewList(newList);

        return newList;
    }

    private void copyDataNewList(E[] newList) {
        IntStream.range(0, index)
                .forEach(i -> newList[i] = data[i]);
    }

    private boolean isFull() {
        return size == index;
    }

    public void remove(int deleteIdx) {
        validateIndex(index);
        for (int i = deleteIdx + 1; i <= index; i++) {
            data[deleteIdx] = data[deleteIdx + 1];
        }
        index--;
    }
}

class TestArrayList {

    @Test
    void create() {
        ArrayList<String> arrayList = new ArrayList<>();
    }

    @Test
    void add() {
        // given
        ArrayList<String> spyList = Mockito.spy(new ArrayList());

        IntStream.range(0, 10)
                .mapToObj(i -> "data " + i)
                .forEach(spyList::add);

        // when, then
        Mockito.verify(spyList, Mockito.times(10)).add(Mockito.any());
        assertThat(spyList.getIndex()).isEqualTo(9);
    }

    @Test
    void get() {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("item 1");
        arrayList.add("item 2");
        arrayList.add("item 3");

        assertAll(
                () -> assertEquals("item 1", arrayList.get(0)),
                () -> assertEquals("item 2", arrayList.get(1)),
                () -> assertEquals("item 3", arrayList.get(2))
        );
    }

    @Test
    void get_throw_ArrayIndexOutOfBoundsException() {
        ArrayList<String> arrayList = new ArrayList<>();

        assertThatExceptionOfType(ArrayIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    arrayList.get(4);
                    arrayList.get(5);
                    arrayList.get(100);
                });
    }

    @Test
    void get_throw_IllegalArgumentException() {
        ArrayList<String> arrayList = new ArrayList<>();

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    arrayList.get(-1);
                    arrayList.get(-2);
                    arrayList.get(-100);
                });
    }

    @Test
    void remove() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("item 1");
        arrayList.add("item 2");
        arrayList.add("item 3");

        arrayList.remove(1);

        assertThat(arrayList.get(1)).isEqualTo("item 3");
        assertThat(arrayList.getIndex()).isEqualTo(1);
    }
}
