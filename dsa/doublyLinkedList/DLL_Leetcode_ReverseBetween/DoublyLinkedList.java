package dsa.doublyLinkedList.DLL_Leetcode_ReverseBetween;

public class DoublyLinkedList {
    private Node head;

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
    }

    public Node getHead() {
        return head;
    }

    public void printList() {
        StringBuilder output = new StringBuilder();
        Node temp = head;
        while (temp != null) {
            output.append(temp.value);
            if (temp.next != null) {
                output.append(" <-> ");
            }
            temp = temp.next;
        }
        System.out.println(output.toString());
    }

    public void makeEmpty() {
        head = null;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    public void reverseBetween(int startIndex, int endIndex) {
        if (head == null || startIndex == endIndex) {
            return;
        }

        // Create a dummy node to simplify edge cases
        Node dummy = new Node(0);
        dummy.next = head;
        head.prev = dummy;

        // Step 1: Move 'prev' to the node before startIndex
        Node prev = dummy;
        for (int i = 0; i < startIndex; i++) {
            prev = prev.next;
        }

        // Step 2: Start reversing from 'current' = prev.next
        Node current = prev.next;

        // Step 3: Reverse by relocating nodes one at a time
        for (int i = 0; i < endIndex - startIndex; i++) {
            Node nodeToMove = current.next;

            // Remove nodeToMove from its place
            current.next = nodeToMove.next;
            if (nodeToMove.next != null) {
                nodeToMove.next.prev = current;
            }

            // Move nodeToMove to the front of the sublist
            nodeToMove.next = prev.next;
            prev.next.prev = nodeToMove;

            prev.next = nodeToMove;
            nodeToMove.prev = prev;
        }

        // Step 4: Update head in case it changed
        head = dummy.next;
        head.prev = null;
    }

}
