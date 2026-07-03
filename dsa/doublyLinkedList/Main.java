package dsa.doublyLinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList myDLL = new DoublyLinkedList(1);
        System.out.println("Head: " + myDLL.getHead().value);
        System.out.println("Tail: " + myDLL.getTail().value);
        System.out.println("Length: " + myDLL.getLength());
        myDLL.printList();
        myDLL.append(2);
        myDLL.printList();
    }
}
