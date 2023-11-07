package structure.graphs;

import java.util.LinkedList;

class Queue<T> {

}

class Graph {
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
}

public class Test {
    public static void main(String[] args) {

    }
}
