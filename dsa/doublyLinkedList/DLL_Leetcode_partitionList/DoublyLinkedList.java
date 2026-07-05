package dsa.doublyLinkedList.DLL_Leetcode_partitionList;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
        }
    }

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public Node getHead() {
        return head;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    // PartitionList
    public void partitionList(int x) {
        if (head == null)
            return;
        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);
        Node prev1 = dummy1;
        Node prev2 = dummy2;
        Node current = head;
        while (current != null) {
            if (current.value < x) {
                prev1.next = current;
                current.prev = prev1;
                prev1 = current;
            } else {
                prev2.next = current;
                current.prev = prev2;
                prev2 = current;
            }
            current = current.next;
        }
        prev2.next = null;
        prev1.next = dummy2.next;
        if (dummy2.next != null) {
            dummy2.next.prev = prev1;
        }
        head = dummy1.next;
        if (head != null) {
            head.prev = null;
        }

    }
}
