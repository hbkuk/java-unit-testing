package structure.list;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class SingleLinkedList {
    private Node head;

    public void addToHead(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    public void removeHead() {
        if (head == null) {
            throw new RuntimeException();
        }
        head = head.next;
    }

    // 중복된 원소를 제거한다.
    public void removeDuplicateData() {
        Set<Integer> set = new HashSet<>();

        Node prevNode = head;
        Node currentNode = head;
        while (currentNode != null) {
            if (!set.contains(currentNode.data)) {
                set.add(currentNode.data);
                prevNode = currentNode;
            }
            if (set.contains(currentNode.data)) {
                prevNode.next = currentNode.next;
            }
            currentNode = currentNode.next;
        }
    }

    // 역순으로 출력한다.
    public void reverse() {
        Stack<Node> stack = new Stack<>();
        Node current = head;
        while (current != null) {
            stack.push(current);
            current = current.next;
        }
        while (!stack.isEmpty()) {
            // 하나씩 꺼내어서 작업
            // stack.pop()
        }
    }

    // k번째 원소를 찾는다.
    public int indexOf(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("인덱스는 0 이상이어야 합니다.");
        }

        int currentIndex = 0;
        Node currentNode = head;
        while (currentNode != null) {
            if (currentIndex == index) {
                return currentNode.data;
            }
            currentNode = currentNode.next;
            currentIndex++;
        }

        throw new IndexOutOfBoundsException("주어진 인덱스가 LinkedList의 범위를 벗어납니다.");
    }


    // 회문인지 판단한다.
    public boolean isPalindrome() {
        if (head == null) {
            throw new RuntimeException("들어있지도 않은데요?");
        }

        Stack<Integer> stack = new Stack<>();

        Node currentNode = head;
        while (currentNode != null) {
            stack.push(currentNode.data);
            currentNode = currentNode.next;
        }

        currentNode = head;
        while (currentNode != null) {
            if(currentNode.data != stack.pop()) {
                return false;
            }
            currentNode = currentNode.next;
        }
        return true;
    }


    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
