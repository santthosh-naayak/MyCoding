package dsa.linkedlist;

public class Main {
    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList(4);
        System.out.println(myLinkedList); // Prints address
        myLinkedList.getHead();// Prints the Head of linkedList
        myLinkedList.getTail();// Prints the Tail of linkedList
        myLinkedList.getLength();// Prints the length of linkedList
        myLinkedList.printList();// Prints the linkedList
    }
}
