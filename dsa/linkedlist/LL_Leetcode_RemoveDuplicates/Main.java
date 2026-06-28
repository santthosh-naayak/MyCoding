package dsa.linkedlist.LL_Leetcode_RemoveDuplicates;

public class Main {
    public static void main(String[] args) {
        LinkedList myLinkedList;

        // Test 1: Empty list
        System.out.println("Test 1: Empty List");
        myLinkedList = new LinkedList(1);
        myLinkedList.makeEmpty();
        myLinkedList.removeDuplicates();
        System.out.println("Expected: List is empty");
        myLinkedList.printList();
        System.out.println();

        // Test 2: Single node (no duplicates)
        System.out.println("Test 2: Single Node");
        myLinkedList = new LinkedList(10);
        myLinkedList.removeDuplicates();
        System.out.println("Expected: 10");
        myLinkedList.printList();
        System.out.println();

        // Test 3: Multi-node (no duplicates)
        System.out.println("Test 3: No Duplicates");
        myLinkedList = new LinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.removeDuplicates();
        System.out.println("Expected: 1 -> 2 -> 3");
        myLinkedList.printList();
        System.out.println();

        // Test 4: Duplicates in the middle
        System.out.println("Test 4: Duplicates in Middle");
        myLinkedList = new LinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.removeDuplicates();
        System.out.println("Expected: 1 -> 2 -> 3");
        myLinkedList.printList();
        System.out.println();

        // Test 5: All elements are duplicates
        System.out.println("Test 5: All Duplicates");
        myLinkedList = new LinkedList(5);
        myLinkedList.append(5);
        myLinkedList.append(5);
        myLinkedList.append(5);
        myLinkedList.removeDuplicates();
        System.out.println("Expected: 5");
        myLinkedList.printList();
        System.out.println();

        // Test 6: Duplicates at start and end
        System.out.println("Test 6: Duplicates at Start/End");
        myLinkedList = new LinkedList(1);
        myLinkedList.append(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(3);
        myLinkedList.removeDuplicates();
        System.out.println("Expected: 1 -> 2 -> 3");
        myLinkedList.printList();
        System.out.println();

        // Test 7: Mixed duplicates throughout
        System.out.println("Test 7: Mixed Duplicates");
        myLinkedList = new LinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(1);
        myLinkedList.append(3);
        myLinkedList.append(2);
        myLinkedList.append(4);
        myLinkedList.removeDuplicates();
        System.out.println("Expected: 1 -> 2 -> 3 -> 4");
        myLinkedList.printList();
        System.out.println();

        /*
         * UPDATED EXPECTED OUTPUT:
         * -------------------------
         * Test 1: Empty List
         * Expected: List is empty
         * List is empty
         * 
         * Test 2: Single Node
         * Expected: 10
         * 10
         * 
         * Test 3: No Duplicates
         * Expected: 1 -> 2 -> 3
         * 1 -> 2 -> 3
         * 
         * Test 4: Duplicates in Middle
         * Expected: 1 -> 2 -> 3
         * 1 -> 2 -> 3
         * 
         * Test 5: All Duplicates
         * Expected: 5
         * 5
         * 
         * Test 6: Duplicates at Start/End
         * Expected: 1 -> 2 -> 3
         * 1 -> 2 -> 3
         * 
         * Test 7: Mixed Duplicates
         * Expected: 1 -> 2 -> 3 -> 4
         * 1 -> 2 -> 3 -> 4
         */
    }
}
