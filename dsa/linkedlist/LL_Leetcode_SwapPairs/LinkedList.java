package dsa.linkedlist.LL_Leetcode_SwapPairs;

public class LinkedList {
    private Node head;

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
    }

    public Node getHead() {
        return head;
    }

    public void makeEmpty() {
        head = null;
    }

    public void printList() {
        Node temp = head;
        if (temp == null) {
            System.out.println("empty");
        } else {
            while (temp != null) {
                System.out.print(temp.value);
                temp = temp.next;
                if (temp != null) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        }
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Swap Nodes in Pairs
    /*
     * Write a method swapPairs() inside a LinkedList class that swaps every two
     * adjacent nodes in a singly linked list.
     * 
     * This method should update the linked list in-place by changing the next
     * pointers — not by swapping values.
     * 
     * The Linked List does not have tail or length attributes (you will not need
     * them).
     * 
     * The method should work correctly for:
     * 
     * empty lists,
     * 
     * single-node lists,
     * 
     * even-length lists,
     * 
     * odd-length lists.
     * 
     * 
     * 
     * 
     * 
     * 📘 What This Exercise Is Designed to Teach
     * 
     * How to manipulate linked list node pointers
     * 
     * How to use a dummy node for edge-case handling
     * 
     * How to track and reassign next pointers safely
     * 
     * How to perform in-place node swaps
     * 
     * How to traverse a linked list using multiple pointers
     */
    public void swapPairs() {
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;
        while (prev.next != null && prev.next.next != null) {
            Node first = prev.next;
            Node second = first.next;
            // Perform the swap
            first.next = second.next;
            second.next = first;

            // Move pointers
            prev.next = second;
            prev = first;
        }
        head = dummy.next;
    }

}
