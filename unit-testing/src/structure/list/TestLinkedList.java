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
}

class LinkedList<T> {
    private final Node<T> header;
    private int size;

    public LinkedList() {
        this.header = new Node<>();
    }

    public int size() {
        return size;
    }

    public void append(T data) {
        Node<T> newNode = new Node(data);

        if (isHeaderEmpty()) {
            header.next = newNode;
        } else {
            Node<T> tempNode = header;
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            tempNode.next = newNode;
        }
        size ++;
    }

    private boolean isHeaderEmpty() {
        return header.next == null;
    }

    public void delete(T data) {
        Node<T> tempNode = header;

        while (tempNode.next != null) {
            if (tempNode.next.data == data) {
                tempNode.next = tempNode.next.next;
            } else {
                tempNode = tempNode.next;
            }
        }
        size --;
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