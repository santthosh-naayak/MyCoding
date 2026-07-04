package dsa.doublyLinkedList.DLL_Leetcode_Palindrome_Check;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    // Constructor
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

    // printList
    public void printList() {
        if (length == 0) {
            System.out.println("empty");
        }
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
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

    // check palindrome
    public boolean isPalindrome() {
        if (length <= 1)
            return true;
        Node forwardNode = head;
        Node backwardNode = tail;
        for (int i = 0; i <= length / 2; i++) {
            if (forwardNode.value != backwardNode.value)
                return false;
            forwardNode = forwardNode.next;
            backwardNode = backwardNode.prev;
        }
        return true;
    }

}
