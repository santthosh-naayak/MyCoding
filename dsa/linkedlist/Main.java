package dsa.linkedlist;

public class Main {
    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList(4);
        System.out.println(myLinkedList); // Prints address
        myLinkedList.append(6);// append value
        myLinkedList.getHead();// Prints the Head of linkedList
        myLinkedList.getTail();// Prints the Tail of linkedList
        myLinkedList.getLength();// Prints the length of linkedList
        System.out.println("Printing List");
        myLinkedList.printList();// Prints the linkedList 4 and 6
        System.out.println("Removing last");
        System.out.println(myLinkedList.removeLast().value); // removed the last 6
        System.out.println(myLinkedList.removeLast().value); // removed the last which has only one 4
        System.out.println(myLinkedList.removeLast()); /*
                                                        * after removing the last the linkedList becomes null, hence
                                                        * null.value will cause NullPointer exception, no .value is
                                                        * removed it will print null
                                                        */
        System.out.println("New Linked List");
        LinkedList myLinkedList2 = new LinkedList(2);
        myLinkedList2.append(3);
        myLinkedList2.prepend(1); // Prepend
        myLinkedList2.printList();
        System.out.println("Removing the first");
        System.out.println(myLinkedList2.removeFirst().value);// removing the first
        System.out.println(myLinkedList2.removeFirst().value);// removing the first of remaining
        System.out.println(myLinkedList2.removeFirst().value);// removing the first of remaining
        System.out.println(myLinkedList2.removeFirst());// length became zero so returning null

        System.out.println("get by index");
        LinkedList myLinkedList3 = new LinkedList(0);
        myLinkedList3.append(1);
        myLinkedList3.append(2);
        myLinkedList3.append(3);
        System.err.println(myLinkedList3.get(2).value + "\n");// getting the value of node at index 2
        myLinkedList3.printList();
        System.out.println("Set Method" + "\n");
        // set method
        myLinkedList3.set(3, 5);// setting the value 5 at index 3
        myLinkedList3.printList();
    }
}
