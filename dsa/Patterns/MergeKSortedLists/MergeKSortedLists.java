package dsa.Patterns.MergeKSortedLists;

import java.util.PriorityQueue;

/*You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

Example 1:
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted linked list:
1->1->2->3->4->4->5->6

Example 2:
Input: lists = []
Output: []

Example 3:
Input: lists = [[]]
Output: []

Constraints:

k == lists.length
0 <= k <= 104
0 <= lists[i].length <= 500
-104 <= lists[i][j] <= 104
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 104. */
public class MergeKSortedLists {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        };

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        // Create a Min Heap (Priority Queue).
        // The smallest node value will always be available at the top.
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        // Every linked list is already sorted.
        // Insert only the first node (head) of each list into the heap.
        // The heap now knows the smallest candidate from every list.
        for (ListNode head : lists) {
            if (head != null) {
                minHeap.offer(head);
            }
        }
        // Dummy node simplifies building the final merged list.
        // It avoids handling the special case for the first node.
        ListNode dummyNode = new ListNode(0);
        // Current always points to the last node
        // in the merged linked list.
        ListNode current = dummyNode;
        // Continue until every node from every list
        // has been processed.
        while (!minHeap.isEmpty()) {
            // Remove the smallest available node
            // among all K linked lists. Means like checking items off a to-do list
            ListNode smallest = minHeap.poll();
            // Attach this smallest node to the merged list.
            current.next = smallest;
            // move current forward
            current = current.next;
            // The node we just removed came from one
            // particular linked list.
            //
            // That list may still contain more nodes.
            //
            // Insert the next node from the same list
            // into the heap so it can compete with
            // nodes from the other linked lists.
            if (smallest.next != null) {
                minHeap.offer(smallest.next);
            }
        }
        // Skip the dummy node and return the real head.
        return dummyNode.next;
    }

    public static void main(String[] args) {
        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        System.out.println("========== Example 1 ==========");

        MergeKSortedLists.ListNode[] lists = {

                mergeKSortedLists.createList(new int[] { 1, 4, 5 }),
                mergeKSortedLists.createList(new int[] { 1, 3, 4 }),
                mergeKSortedLists.createList(new int[] { 2, 6 })
        };

        System.out.println("Input:");

        mergeKSortedLists.printList(lists[0]);
        mergeKSortedLists.printList(lists[1]);
        mergeKSortedLists.printList(lists[2]);

        System.out.println();

        System.out.println("Expected Output:");
        System.out.println("1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6");

        System.out.println();

        System.out.println("Actual Output:");
        mergeKSortedLists.printList(
                mergeKSortedLists.mergeKLists(lists));
    }

    // Create a linked list from an integer array.
    public ListNode createList(int[] values) {

        ListNode dummyNode = new ListNode(0);
        ListNode current = dummyNode;

        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }

        return dummyNode.next;
    }

    // Print the linked list as:
    // 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6
    public void printList(ListNode head) {
        if (head == null) {
            System.out.println("Empty List");
            return;
        }
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
        System.out.println();
    }
}
