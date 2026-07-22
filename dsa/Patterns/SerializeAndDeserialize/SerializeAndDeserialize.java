package dsa.Patterns.SerializeAndDeserialize;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.


Example 1:
Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]

Example 2:
Input: root = []
Output: []
 
Constraints:

The number of nodes in the tree is in the range [0, 10^4].
-1000 <= Node.val <= 1000 */
public class SerializeAndDeserialize {
    // Represents a node in the binary tree.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        // Create a node with the given value.
        TreeNode(int val) {
            this.val = val;
        }
    }

    // -----------------------------------------------------------
    // SERIALIZATION
    // Convert the binary tree into a string.
    // -----------------------------------------------------------
    public String serialize(TreeNode root) {
        // Efficiently build the serialized string.
        StringBuffer sb = new StringBuffer();
        // Start recursive preorder traversal.
        serialize(root, sb);
        // Return the completed serialized string.
        return sb.toString();
    }

    // Helper method to recursively serialize the tree.
    public void serialize(TreeNode node, StringBuffer sb) {
        // Record null nodes so the original structure is preserved.
        if (node == null) {
            sb.append("null,");
            return;
        }
        // Save the current node value.
        sb.append(node.val).append(",");
        // Serialize the left subtree.
        serialize(node.left, sb);
        // Serialize the right subtree.
        serialize(node.right, sb);
    }

    // -----------------------------------------------------------
    // DESERIALIZATION
    // Reconstruct the original tree from the serialized string.
    // -----------------------------------------------------------
    public TreeNode deserialize(String data) {
        // Break the string into individual values.
        String[] values = data.split(",");
        // Queue preserves the preorder sequence during reconstruction.
        Queue<String> queue = new LinkedList<>();
        // Load every value into the queue.
        for (String value : values) {
            queue.offer(value);
        }
        // Build the tree recursively.
        return buildTree(queue);
    }

    // Helper method to recursively rebuild the tree.
    private TreeNode buildTree(Queue<String> queue) {
        // Read the next value in preorder.
        String value = queue.poll();
        // Null marker means there is no node here.
        if (value.equals("null")) {
            return null;
        }
        // Create the current node.
        TreeNode node = new TreeNode(Integer.parseInt(value));
        // Build the left subtree.
        node.left = buildTree(queue);
        // Build the right subtree.
        node.right = buildTree(queue);
        // Return the reconstructed subtree.
        return node;
    }

    public static void main(String[] args) {

        SerializeAndDeserialize serializeAndDeserialize = new SerializeAndDeserialize();

        // =========================
        // Example 1
        // =========================
        System.out.println("Example 1");

        TreeNode root = serializeAndDeserialize.new TreeNode(1);
        root.left = serializeAndDeserialize.new TreeNode(2);
        root.right = serializeAndDeserialize.new TreeNode(3);
        root.right.left = serializeAndDeserialize.new TreeNode(4);
        root.right.right = serializeAndDeserialize.new TreeNode(5);

        System.out.print("Original Tree           : ");
        serializeAndDeserialize.printLevelOrder(root);

        String serialized = serializeAndDeserialize.serialize(root);

        System.out.println("Serialized String       : " + serialized);

        TreeNode newRoot = serializeAndDeserialize.deserialize(serialized);

        System.out.print("Deserialized Tree       : ");
        serializeAndDeserialize.printLevelOrder(newRoot);

        // =========================
        // Example 2
        // =========================
        System.out.println("\nExample 2");

        TreeNode emptyRoot = null;

        System.out.print("Original Tree           : ");
        serializeAndDeserialize.printLevelOrder(emptyRoot);

        String serializedEmpty = serializeAndDeserialize.serialize(emptyRoot);

        System.out.println("Serialized String       : " + serializedEmpty);

        TreeNode newEmptyRoot = serializeAndDeserialize.deserialize(serializedEmpty);

        System.out.print("Deserialized Tree       : ");
        serializeAndDeserialize.printLevelOrder(newEmptyRoot);
    }

    // Print the binary tree in LeetCode's Level Order format.
    public void printLevelOrder(TreeNode root) {

        if (root == null) {
            System.out.println("[]");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        List<String> result = new ArrayList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode current = queue.poll();

            if (current == null) {
                result.add("null");
            } else {
                result.add(String.valueOf(current.val));

                // Continue exploring both children.
                queue.offer(current.left);
                queue.offer(current.right);
            }
        }

        // Remove unnecessary trailing nulls.
        while (!result.isEmpty() && result.get(result.size() - 1).equals("null")) {
            result.remove(result.size() - 1);
        }

        System.out.println(result);
    }
}
