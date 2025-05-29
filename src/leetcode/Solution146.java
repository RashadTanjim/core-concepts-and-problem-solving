package leetcode;

import leetcode.common.NodeLRU;

import java.util.HashMap;
import java.util.Map;

public class Solution146 {

    private final int capacity;
    private final Map<Integer, NodeLRU> cache;
    private final NodeLRU head;
    private final NodeLRU tail;

    public Solution146(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();

        head = new NodeLRU(0, 0);
        tail = new NodeLRU(0, 0);
        head.setNext(tail);
        tail.setPrev(head);
    }

    // Get value for the key, move it to front if exists
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        NodeLRU node = cache.get(key);
        remove(node);
        insertAtFront(node);
        return node.getValue();
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        if (cache.size() == capacity) {
            remove(tail.getPrev());
        }
        insertAtFront(new NodeLRU(key, value));
    }

    private void remove(NodeLRU node) {
        cache.remove(node.getKey());
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
    }

    // Insert a node at the front (most recently used position)
    private void insertAtFront(NodeLRU node) {
        cache.put(node.getKey(), node);
        node.setNext(head.getNext());
        node.setPrev(head);
        head.getNext().setPrev(node);
        head.setNext(node);
    }


    public static void main(String[] args) {
        Solution146 cache = new Solution146(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // Output: 1
        cache.put(3, 3); // Removes key 2
        System.out.println(cache.get(2)); // Output: -1
        cache.put(4, 4); // Removes key 1
        System.out.println(cache.get(1)); // Output: -1
        System.out.println(cache.get(3)); // Output: 3
        System.out.println(cache.get(4)); // Output: 4
    }

}