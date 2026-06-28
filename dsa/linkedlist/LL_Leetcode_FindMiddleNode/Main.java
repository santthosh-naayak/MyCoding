package dsa.linkedlist.LL_Leetcode_FindMiddleNode;

public class Main {
    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList(1);
        System.out.println(myLinkedList);
        myLinkedList.append(2);
        myLinkedList.append(3);
        System.out.println("Printing List");
        myLinkedList.printList();
        // Find Middle Length
        System.out.println("Print Middle Node - Odd length");
        System.err.println(myLinkedList.findMiddleNode().value);
        System.out.println("Append More vales to make length Even");
        myLinkedList.append(4);
        myLinkedList.append(5);
        myLinkedList.append(6);
        System.out.println("Printing List");
        myLinkedList.printList();
        System.out.println("Print Middle Node - Even length");
        System.out.println(myLinkedList.findMiddleNode().value);
    }
}
