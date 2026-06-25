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

}
