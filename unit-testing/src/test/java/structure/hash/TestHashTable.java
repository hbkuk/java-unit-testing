package structure.hash;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestHashTable {

    @Test
    void getHashCode() {
        HashTable hashTable = new HashTable(3);
        assertTrue(hashTable.getHashCode("황병국") > 0);
    }

    @Test
    void convertToIndex() {
        HashTable hashTable = new HashTable(3);
        assertEquals(0, hashTable.convertToIndex(123));
        assertEquals(1, hashTable.convertToIndex(1254334));
    }

    @Test
    void putAndGet() {
        HashTable hashTable = new HashTable(3);
        hashTable.put("phone", "apple");
        hashTable.put("hub", "banana");
        hashTable.put("twice", "momo");
        hashTable.put("twice", "tt");

        assertEquals("apple", hashTable.get("phone"));
        assertEquals("banana", hashTable.get("hub"));
        assertEquals(null, hashTable.get("nano"));
        assertEquals("tt", hashTable.get("twice"));
    }
}

class HashTable {
    LinkedList<Node>[] data;

    public HashTable(int size) {
        this.data = new LinkedList[size];
    }

    public int getHashCode(String key) {
        int hashCode = 0;
        for (char c : key.toCharArray()) {
            hashCode += c;
        }

        return hashCode;
    }

    public int convertToIndex(int hashCode) {
        return hashCode % data.length;
    }

    public Node searchKey(LinkedList<Node> list, String key) {
        if (list == null) {
            return null;
        }

        for (Node node : list) {
            if (node.key.equals(key)) {
                return node;
            }
        }
        return null;
    }

    public void put(String key, String value) {
        int hashCode = getHashCode(key);
        int index = convertToIndex(hashCode);

        LinkedList<Node> list = data[index];
        if (list == null) {
            list = new LinkedList<Node>();
            data[index] = list;
        }

        Node node = searchKey(list, key);
        if (node == null) {
            list.add(new Node(key, value));
        } else {
            node.value = value; // 중복 값 대체
        }
    }

    public String get(String key) {
        int hashCode = getHashCode(key);
        int index = convertToIndex(hashCode);

        LinkedList<Node> list = data[index];
        Node node = searchKey(list, key);

        return node == null ? null : node.getValue();
    }

    class Node {
        String key;
        String value;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

}