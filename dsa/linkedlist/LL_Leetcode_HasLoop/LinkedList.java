package dsa.linkedlist.LL_Leetcode_HasLoop;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    // PrintList
    public void printList() {
        Node temp = head;
        while (temp.next != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    // getHead
    public Node getHead() {
        if (head != null) {
            return head;
        } else {
            return null;
        }
    }

    // getTail
    public Node getTail() {
        if (tail != null) {
            return tail;
        } else {
            return null;
        }
    }

    // get length
    public int getLength() {
        return length;
    }

    // make Empty
    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    // append
    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // HasLoop
    public boolean hasLoop() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
