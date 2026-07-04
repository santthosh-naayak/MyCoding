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
        System.out.println(myDLL.removeLast().value);
        System.out.println(myDLL.removeLast().value);
        System.out.println(myDLL.removeLast());
        myDLL.append(1);
        myDLL.append(2);
        System.out.println("New DLL");
        myDLL.printList();
        myDLL.prepend(0);
        myDLL.printList();
        System.out.println("Removing First");
        myDLL.removeFirst();
        myDLL.printList();
        System.out.println("Printing the node value at given index");
        System.out.println(myDLL.get(0).value);
        System.out.println(myDLL.get(1).value);
        System.out.println("Setting the value as 0 at index 0");
        myDLL.set(0, 0);
        System.out.println("Setting the value as 1 at index 1");
        myDLL.set(1, 1);
        myDLL.printList();
        System.out.println("insert at end");
        myDLL.insert(2, 3);
        myDLL.printList();
        System.out.println("Insert at beginning");
        myDLL.insert(0, 7);
        myDLL.printList();
        System.out.println("insert");
        myDLL.insert(1, 5);
        myDLL.printList();
        System.out.println("Remove Node at last");
        myDLL.remove(4);
        myDLL.printList();
        System.out.println("Remove at first");
        myDLL.remove(0);
        myDLL.printList();
        System.out.println("removing at index");
        System.out.println(myDLL.remove(1).value);
        System.out.println("Printing the list");
        myDLL.printList();
    }
}
