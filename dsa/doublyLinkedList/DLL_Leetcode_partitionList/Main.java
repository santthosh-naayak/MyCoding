package dsa.doublyLinkedList.DLL_Leetcode_partitionList;

public class Main {
    private static void printForward(DoublyLinkedList dll) {
        DoublyLinkedList.Node current = dll.getHead();
        if (current == null) {
            System.out.println("Forward: empty");
            return;
        }
        System.out.print("Forward: ");
        while (current != null) {
            System.out.print(current.value);
            if (current.next != null)
                System.out.print(" <-> ");
            current = current.next;
        }
        System.out.println();
    }

    private static void printBackward(DoublyLinkedList dll) {
        DoublyLinkedList.Node current = dll.getHead();
        if (current == null) {
            System.out.println("Backward: empty");
            return;
        }
        while (current.next != null)
            current = current.next; // move to tail
        System.out.print("Backward: ");
        while (current != null) {
            System.out.print(current.value);
            if (current.prev != null)
                System.out.print(" <-> ");
            current = current.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList dll;

        // Explain why we do forward and backward prints
        System.out.println("We print each list forward and backward");
        System.out.println("to confirm BOTH next and prev pointers");
        System.out.println("are correct after reverseBetween.");
        System.out.println();

        // Test 1: Empty list
        System.out.println("Test 1: Empty List");
        dll = new DoublyLinkedList(1);
        dll.makeEmpty();
        dll.partitionList(3);
        System.out.println("Expected Forward: empty");
        System.out.println("Expected Backward: empty");
        printForward(dll);
        printBackward(dll);
        System.out.println();

        // Test 2: Single node (< x)
        System.out.println("Test 2: Single Node (< x)");
        dll = new DoublyLinkedList(1);
        dll.partitionList(5);
        System.out.println("Expected Forward: 1");
        System.out.println("Expected Backward: 1");
        printForward(dll);
        printBackward(dll);
        System.out.println();

        // Test 3: Single node (>= x)
        System.out.println("Test 3: Single Node (>= x)");
        dll = new DoublyLinkedList(9);
        dll.partitionList(5);
        System.out.println("Expected Forward: 9");
        System.out.println("Expected Backward: 9");
        printForward(dll);
        printBackward(dll);
        System.out.println();

        // Test 4: All nodes < x
        System.out.println("Test 4: All Nodes < x");
        dll = new DoublyLinkedList(1);
        dll.append(2);
        dll.append(3);
        dll.partitionList(5);
        System.out.println("Expected Forward: 1 <-> 2 <-> 3");
        System.out.println("Expected Backward: 3 <-> 2 <-> 1");
        printForward(dll);
        printBackward(dll);
        System.out.println();

        // Test 5: All nodes >= x
        System.out.println("Test 5: All Nodes >= x");
        dll = new DoublyLinkedList(7);
        dll.append(8);
        dll.append(9);
        dll.partitionList(5);
        System.out.println("Expected Forward: 7 <-> 8 <-> 9");
        System.out.println("Expected Backward: 9 <-> 8 <-> 7");
        printForward(dll);
        printBackward(dll);
        System.out.println();

        // Test 6: Mixed nodes
        System.out.println("Test 6: Mixed Nodes");
        dll = new DoublyLinkedList(3);
        dll.append(5);
        dll.append(8);
        dll.append(5);
        dll.append(10);
        dll.append(2);
        dll.append(1);
        dll.partitionList(5);
        System.out.println("Expected Forward: 3 <-> 2 <-> 1 <-> 5 <-> 8 <-> 5 <-> 10");
        System.out.println("Expected Backward: 10 <-> 5 <-> 8 <-> 5 <-> 1 <-> 2 <-> 3");
        printForward(dll);
        printBackward(dll);
        System.out.println();

        // Test 7: Duplicates around pivot
        System.out.println("Test 7: Duplicates Around Pivot");
        dll = new DoublyLinkedList(5);
        dll.append(1);
        dll.append(5);
        dll.append(0);
        dll.append(5);
        dll.partitionList(5);
        System.out.println("Expected Forward: 1 <-> 0 <-> 5 <-> 5 <-> 5");
        System.out.println("Expected Backward: 5 <-> 5 <-> 5 <-> 0 <-> 1");
        printForward(dll);
        printBackward(dll);
        System.out.println();
    }
}
