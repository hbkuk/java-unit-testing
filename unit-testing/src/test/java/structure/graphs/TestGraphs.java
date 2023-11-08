package structure.graphs;

import lombok.EqualsAndHashCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Queue<T> {
    private LinkedList<T> list = new LinkedList<T>();

    // 큐에 요소를 추가하는 메서드
    public void enqueue(T item) {
        list.addLast(item);
    }

    // 큐에서 요소를 제거하고 반환하는 메서드
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.removeFirst();
    }

    // 큐가 비어있는지 확인하는 메서드
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // 큐의 크기를 반환하는 메서드
    public int size() {
        return list.size();
    }

    // 큐의 맨 앞 요소를 반환하는 메서드 (제거하지 않음)
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.getFirst();
    }
}

@EqualsAndHashCode
class Node {
    int data;
    LinkedList<Node> adjacent;
    boolean marked;

    public Node(int data) {
        this.data = data;
        this.marked = false;
        adjacent = new LinkedList<Node>();
    }
}

class Graph {

    Node[] nodes;

    Graph(int size) {
        nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }
    }

    void addEdge(int i1, int i2) {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];

        if (!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }
        if (!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
    }

    List<Node> dfs() {
        return dfs(0);
    }

    List<Node> dfs(int startIdx) {
        List<Node> result = new ArrayList<>();

        Node root = nodes[startIdx];
        Stack<Node> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            node.marked = true;

            node.adjacent.stream()
                    .filter(n -> n.marked != true)
                    .forEach(stack::push);

            result.add(node);
        }
        return result;
    }

    List<Node> dfsR() {
        return dfsR(nodes[0], new ArrayList<>());
    }

    List<Node> dfsR(Node r, List<Node> result) {
        if (r == null) {
            return null;
        }
        r.marked = true;
        result.add(r);

        for (Node n : r.adjacent) {
            if (!n.marked) {
                dfsR(n, result);
            }
        }
        return result;
    }

    List<Node> bfs() {
        return bfs(0);
    }

    List<Node> bfs(int startIdx) {
        List<Node> result = new ArrayList<>();

        Node root = nodes[startIdx];
        Queue<Node> queue = new Queue<>();

        queue.enqueue(root);

        while (!queue.isEmpty()) {
            Node node = queue.dequeue();
            node.marked = true;

            node.adjacent.stream()
                    .filter(n -> !n.marked)
                    .forEach(queue::enqueue);

            result.add(node);
        }
        return result;
    }
}

public class TestGraphs {

    Graph graph;

    @BeforeEach
    void setUp() {
        graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);

        graph.addEdge(1, 3);
        graph.addEdge(1, 4);

        graph.addEdge(2, 5);
    }

    @Test
    void dfs() {
        // when
        List<Node> result = graph.dfs();

        // then
        assertAll(
                () -> assertEquals(0, result.get(0).data),
                () -> assertEquals(2, result.get(1).data),
                () -> assertEquals(5, result.get(2).data),
                () -> assertEquals(1, result.get(3).data),
                () -> assertEquals(4, result.get(4).data),
                () -> assertEquals(3, result.get(5).data)
        );
    }

    @Test
    void dfsR() {
        // when
        List<Node> result = graph.dfsR();

        // then
        assertAll(
                () -> assertEquals(0, result.get(0).data),
                () -> assertEquals(1, result.get(1).data),
                () -> assertEquals(3, result.get(2).data),
                () -> assertEquals(4, result.get(3).data),
                () -> assertEquals(2, result.get(4).data),
                () -> assertEquals(5, result.get(5).data)
        );
    }

    @Test
    void bfs() {
        // when
        List<Node> result = graph.bfs();

        // then
        assertAll(
                () -> assertEquals(0, result.get(0).data),
                () -> assertEquals(1, result.get(1).data),
                () -> assertEquals(2, result.get(2).data),
                () -> assertEquals(3, result.get(3).data),
                () -> assertEquals(4, result.get(4).data),
                () -> assertEquals(5, result.get(5).data)
        );
    }
}
