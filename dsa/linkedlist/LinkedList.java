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
        if (length == 0) {// if length is zero, added value will be head and tail
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head; // we will give head as a pointer to the new node
            head = newNode;// Then we will move head to new node
        }
        length++;
    }

    // Remove first method
    public Node removeFirst() {
        if (length == 0)
            return null; // Checks if linkedlist is null
        Node temp = head; // as we will return node, lets initially say temp as head
        head = head.next; // move head to head.next as we are removing the head
        temp.next = null; // as teamp is head initially, make temp next as null, so initial head is
                          // removed
        length--;
        if (length == 0) { // If linked list has only one Node
            tail = null; // We have already set head as null, so we need to make tail also null to remove
                         // the one and only one node
        }
        return temp; // returning the removed node .
    }

    // get method with index
    public Node get(int index) {
        if (index < 0 || index >= length)
            return null; // index can't be negative and greater than or equal to 0 as index starts with 0
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // set the value by index
    public boolean set(int index, int value) {
        Node temp = get(index); // We can use get method to get the node at that index
        if (temp != null) {
            temp.value = value; // setting the value
            return true;
        }
        return false;
    }

    // insert method
    public boolean insert(int index, int value) {
        if (index < 0 || index > length) // Cannot insert at negative index, if index is equal to lenth means to append
            return false;
        if (index == 0) { // Means prepend
            prepend(value);
            return true;
        }
        if (index == length) {// append
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index - 1); // Gettting the previous index of where the new node to insert by get method
        newNode.next = temp.next; // set the pointer first
        temp.next = newNode;// as we got the previous node by index we can next next to new node
        length++;// as we are inserting, this will increase the length
        return true;
    }

}
