package dsa.linkedlist.LL_Leetcode_SwapPairs;

public class Main {
    public static void main(String[] args) {
        LinkedList myLinkedList;

        // Test 1: Empty list
        System.out.println("Test 1: Empty List");
        myLinkedList = new LinkedList(1);
        myLinkedList.makeEmpty();
        myLinkedList.swapPairs();
        System.out.println("Expected: empty");
        myLinkedList.printList();
        System.out.println();

        // Test 2: Single node (no swap)
        System.out.println("Test 2: Single Node");
        myLinkedList = new LinkedList(10);
        myLinkedList.swapPairs();
        System.out.println("Expected: 10");
        myLinkedList.printList();
        System.out.println();

        // Test 3: Two nodes (swap them)
        System.out.println("Test 3: Two Nodes");
        myLinkedList = new LinkedList(1);
        myLinkedList.append(2);
        myLinkedList.swapPairs();
        System.out.println("Expected: 2 -> 1");
        myLinkedList.printList();
        System.out.println();

        // Test 4: Odd number of nodes (3 nodes)
        System.out.println("Test 4: Odd Length List");
        myLinkedList = new LinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.swapPairs();
        System.out.println("Expected: 2 -> 1 -> 3");
        myLinkedList.printList();
        System.out.println();

        // Test 5: Even number of nodes (4 nodes)
        System.out.println("Test 5: Even Length List");
        myLinkedList = new LinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.swapPairs();
        System.out.println("Expected: 2 -> 1 -> 4 -> 3");
        myLinkedList.printList();
        System.out.println();

        // Test 6: Longer list (6 nodes)
        System.out.println("Test 6: Longer List (6 Nodes)");
        myLinkedList = new LinkedList(1);
        for (int i = 2; i <= 6; i++)
            myLinkedList.append(i);
        myLinkedList.swapPairs();
        System.out.println("Expected: 2 -> 1 -> 4 -> 3 -> 6 -> 5");
        myLinkedList.printList();
        System.out.println();

        /*
         * EXPECTED OUTPUT:
         * ----------------
         * Test 1: Empty List
         * Expected: empty
         * empty
         * 
         * Test 2: Single Node
         * Expected: 10
         * 10
         * 
         * Test 3: Two Nodes
         * Expected: 2 -> 1
         * 2 -> 1
         * 
         * Test 4: Odd Length List
         * Expected: 2 -> 1 -> 3
         * 2 -> 1 -> 3
         * 
         * Test 5: Even Length List
         * Expected: 2 -> 1 -> 4 -> 3
         * 2 -> 1 -> 4 -> 3
         * 
         * Test 6: Longer List (6 Nodes)
         * Expected: 2 -> 1 -> 4 -> 3 -> 6 -> 5
         * 2 -> 1 -> 4 -> 3 -> 6 -> 5
         */
    }
}
