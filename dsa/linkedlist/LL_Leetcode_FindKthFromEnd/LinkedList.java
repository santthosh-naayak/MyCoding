package dsa.linkedlist.LL_Leetcode_FindKthFromEnd;

public class LinkedList {
    private Node head;
    private Node tail;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
    }

    // make empty
    public void makeEmpty() {
        head = null;
        tail = null;
    }

    // append
    public void append(int value) {
        Node newNode = new Node(value);
        Node temp = head;
        if (temp == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Find Kth Node from end
    // You must solve this problem using the two-pointer technique, ensuring the
    // solution runs in a single traversal of the list (O(n) time, O(1) space).

    public Node findKthFromEnd(int k) {
        if (k <= 0)
            return null;
        Node slow = head;
        Node fast = head;
        for (int i = 0; i < k; i++) { // We advance the fast pointer k times. This creates a gap of k nodes between
                                      // fast and slow.
            if (fast == null)
                return null;
            fast = fast.next;
        }
        while (fast != null) {// After the gap is established, we move slow and fast together, one node at a
                              // time.
            slow = slow.next;
            fast = fast.next;
        }
        return slow; // When fast reaches the end (null), slow will be pointing to the node that is k
                     // positions from the end.
    }
}
