package dsa.linkedlist.LL_Leetcode_PartitionList;

public class LinkedList {
    private Node head;
    private int length;

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
        length = 1;
    }

    public void makeEmpty() {
        head = null;
        length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        length++;
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

    // Partion list
    /*
     * You have a singly linked list that DOES NOT HAVE A TAIL POINTER (which will
     * make this method simpler to implement).
     * Given a value x you need to rearrange the linked list such that all nodes
     * with a value less than x come before all nodes with a value greater than or
     * equal to x.
     * Additionally, the relative order of nodes in both partitions should remain
     * unchanged.
     */

    /*
     * dummy1 → Starting node for values < x
     * dummy2 → Starting node for values >= x
     * prev1 → Tail of the first partition
     * prev2 → Tail of the second partition
     * current → Traverses the original linked list
     * Connect both partitions at the end and update the head.
     */
    public void partitionList(int x) {
        Node dummy1 = new Node(0); // dummy node for numbers < x
        Node dummy2 = new Node(0); // dummy node for numbers >= x
        Node prev1 = dummy1;
        Node prev2 = dummy2;
        Node current = head;
        if (head == null)
            return; // If the linked list is empty, there is nothing to partition.
        while (current != null) { // Hence if current is null will not go
            if (current.value < x) {
                prev1.next = current;
                prev1 = current;
            } else {
                prev2.next = current;
                prev2 = current;
            }
            current = current.next;
        }
        prev2.next = null;
        prev1.next = dummy2.next;
        head = dummy1.next;
    }

}
