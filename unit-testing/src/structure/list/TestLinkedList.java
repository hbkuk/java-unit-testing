package structure.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLinkedList {

    @Test
    void append() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.append(33);
        linkedList.append(34);
    }

    @Test
    void size() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.append(33);
        linkedList.append(34);
        assertEquals(2, linkedList.size());
    }

    @Test
    void delete_1() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.append(33);
        linkedList.append(34);
        linkedList.append(35);
        linkedList.delete(34);

        assertEquals(2, linkedList.size());
    }

    @Test
    void delete_2() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.append(33);
        linkedList.append(34);
        linkedList.append(35);
        linkedList.delete(33);

        assertEquals(2, linkedList.size());
    }

    @Test
    void removeDuplicate() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.append(33);
        linkedList.append(34);
        linkedList.append(35);
        assertEquals(3, linkedList.size());

        linkedList.append(33);
        linkedList.append(34);
        linkedList.append(35);
        assertEquals(6, linkedList.size());

        linkedList.append(33);
        linkedList.append(34);
        linkedList.append(35);
        assertEquals(9, linkedList.size());

        linkedList.removeDuplicates();
        assertEquals(3, linkedList.size());
    }
}

class LinkedList<E> {
    private final Node<E> header;
    private int size;

    public LinkedList() {
        this.header = new Node<>();
    }

    public int size() {
        return size;
    }

    public void append(E data) {
        Node<E> newNode = new Node(data);

        if (isHeaderEmpty()) {
            header.next = newNode;
        } else {
            Node<E> tempNode = header;
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            tempNode.next = newNode;
        }
        size++;
    }

    private boolean isHeaderEmpty() {
        return header.next == null;
    }

    public void delete(E data) {
        Node<E> tempNode = header;

        while (tempNode.next != null) {
            if (tempNode.next.data == data) {
                tempNode.next = tempNode.next.next;
            } else {
                tempNode = tempNode.next;
            }
        }
        size--;
    }

    public void removeDuplicates() {
        Node<E> pointer = header.next;
        while (pointer != null) {
            Node<E> runner = pointer;
            while(runner.next != null) {
                if (runner.next.data == pointer.data) {
                    runner.next = runner.next.next;
                    size --;
                } else {
                    runner = runner.next;
                }
            }
            pointer = pointer.next;
        }
    }
}

class Node<T> {
    T data;
    Node<T> next;

    public Node() {
    }

    public Node(T data) {
        this.data = data;
    }
}