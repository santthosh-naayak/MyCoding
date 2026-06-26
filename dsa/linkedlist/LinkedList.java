package dsa.linkedlist;

public class LinkedList {
    // Class variables
    private Node head;
    private Node tail;
    private int length;

    // Nested class Node
    class Node {
        int value;
        Node next;

        // Node Constructor
        Node(int value) {
            this.value = value;
        }
    }

    // LinkedList Constructor
    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    // Method to print the linked list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    // Method to print Head
    public void getHead() {
        System.out.println("Head : " + head.value);
    }

    // Method to print Tail
    public void getTail() {
        System.out.println("Tail : " + tail.value);
    }

    // Method to print Length of LinkedList
    public void getLength() {
        System.out.println("Length : " + length);
    }

    // append method
    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    // removeLast method
    public Node removeLast() {
        if (length == 0)
            return null; // if LinkedList is null
        Node temp = head;
        Node pre = head;
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null; // If LinkedList has more than 1 and length becomes 1
        length--;
        if (length == 0) { // If LinkedList has one node and after removeLast become 0, so make head and
                           // tail as null asit removed the only Node.
            head = null;
            tail = null;
        }
        return temp;
    }

    // Prepend Method
    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

}
