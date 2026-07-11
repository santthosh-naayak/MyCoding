package dsa.Patterns.HashMapAndDLL;

import java.util.HashMap;
import java.util.Map;

/*Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.

Example 1:
Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4
 

Constraints:

1 <= capacity <= 3000
0 <= key <= 104
0 <= value <= 105
At most 2 * 105 calls will be made to get and put. */
public class LRUCache {
    // Maps each key directly to its node for O(1) lookup
    private Map<Integer, Node> cache;
    // Maximum number of entries the cache can store
    private int capacity;
    // Dummy nodes simplify adding and removing nodes
    private Node head;
    private Node tail;

    // Node stores one cache entry and links to neighboring nodes
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        // Create the HashMap for fast key-to-node lookup
        this.cache = new HashMap<>();
        // Create dummy head and tail nodes
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        // Connect the empty doubly linked list
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        // Return -1 if the key does not exist.
        if (!cache.containsKey(key)) {
            return -1;
        }
        // Get the Node directly from the HashMap.
        Node node = cache.get(key);
        // Move the accessed Node to the MRU position.
        removeNode(node);
        addToEnd(node);
        return node.value;
    }

    public void put(int key, int value) {
        /*
         * If the key already exists, update its value and move the node to the MRU
         * position.
         */
        if (cache.containsKey(key)) {
            Node existingNode = cache.get(key);
            existingNode.value = value;
            removeNode(existingNode);
            addToEnd(existingNode);
            return;
        }
        // Create and store a new Node.
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        addToEnd(newNode);
        // Remove the LRU Node if capacity is exceeded.
        if (cache.size() > capacity) {
            // Remove the LRU Node
            Node lruNode = head.next;
            // Remove from the Doubly Linked List.
            removeNode(lruNode);
            // Remove from the HashMap.
            cache.remove(lruNode.key);
        }
    }

    // Add a Node before tail, making it the MRU Node.
    private void addToEnd(Node node) {
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
    }

    // Disconnect a Node from the Doubly Linked List.
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public static void main(String[] args) {
        // Create an LRU cache with capacity 2
        LRUCache lruCache = new LRUCache(2);
        // Add key 1 with value 1.
        lruCache.put(1, 1);
        // Add key 2 with value 2.
        lruCache.put(2, 2);
        // Access key 1. Expected: 1
        System.out.println(lruCache.get(1));
        // Add key 3. Key 2 is the least recently used, so it is removed.
        lruCache.put(3, 3);
        // Key 2 was removed. Expected: -1
        System.out.println(lruCache.get(2));
        // Add key 4. Key 1 is the least recently used, so it is removed.
        lruCache.put(4, 4);
        // Key 1 was removed. Expected: -1
        System.out.println(lruCache.get(1));
        // Key 3 still exists. Expected: 3
        System.out.println(lruCache.get(3));
        // Key 4 still exists. Expected: 4
        System.out.println(lruCache.get(4));
    }
}
