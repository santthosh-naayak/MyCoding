package dsa.doublyLinkedList;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    // nested class Node
    class Node {
        int value;
        Node next;
        Node prev;

        // Node constructor
        Node(int value) {
            this.value = value;
        }
    }

    // Constructor of DLL
    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    // Printing the DLL
    public void printList() {
        Node temp = head;
        if (length == 0) {
            System.out.println("empty");
        } else {
            while (temp != null) {
                System.out.println(temp.value);
                temp = temp.next;
            }
        }
    }

    // append
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

    // remove last
    public Node removeLast() {
        if (length == 0)
            return null;
        Node temp = tail;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }
        length--;
        return temp;
    }

    // prepend
    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    // removeFirst
    public Node removeFirst() {
        if (length == 0)
            return null;
        Node temp = head;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        length--;
        return temp;
    }
}
