package dsa.linkedlist.LL_Leetcode_FindMiddleNode;

public class LinkedList {
    private Node head;
    private Node tail;

    // Nested class
    class Node {
        int value;
        Node next;

        // node Constructor
        public Node(int value) {
            this.value = value;
        }
    }

    // LinkedList Constructor
    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
    }

    // print LinkedList
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    // Append
    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // LL Exercide 1: Find Middle Node
    /*
     * Implement a method called findMiddleNode that returns the middle node of the
     * linked list.
     * If the list has an even number of nodes, the method should return the second
     * middle node.
     * Note: this LinkedList implementation does not have a length member variable.
     */
    public Node findMiddleNode() { // Floyds's Tortoise and Hare algorithm
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
