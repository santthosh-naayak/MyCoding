package dsa.Patterns.DfsAndValidRange;

/*Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys strictly less than the node's key.
The right subtree of a node contains only nodes with keys strictly greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Example 1:
Input: root = [2,1,3]
Output: true

Example 2:
Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
 
Constraints:
The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1 */
public class DfsAndValidRange {
    // Definition of Binary tree node
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        // Constructors
        TreeNode() {
        };

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // validating a binary tree
    public boolean isValidBST(TreeNode root) {
        // Start DFS with a range wider than all possible int values.
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max) {
        // An empty tree or subtree is valid.
        if (node == null) {
            return true;
        }
        // The current value must be strictly inside the valid range.
        if (node.val <= min || node.val >= max) {
            return false;
        }
        // Validate the left and right subtrees with updated ranges.
        // Left subtree: current value becomes the new maximum.
        // Right subtree: current value becomes the new minimum.
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }

    public static void main(String[] args) {
        DfsAndValidRange dfsAndValidRange = new DfsAndValidRange();
        // Example1:
        TreeNode root1 = dfsAndValidRange.new TreeNode(2);
        root1.left = dfsAndValidRange.new TreeNode(1);
        root1.right = dfsAndValidRange.new TreeNode(3);
        boolean result1 = dfsAndValidRange.isValidBST(root1);
        System.out.println(result1);
        // Example 2:
        TreeNode root2 = dfsAndValidRange.new TreeNode(5);
        root2.left = dfsAndValidRange.new TreeNode(1);
        root2.right = dfsAndValidRange.new TreeNode(4);
        root2.right.left = dfsAndValidRange.new TreeNode(3);
        root2.right.right = dfsAndValidRange.new TreeNode(6);
        boolean result2 = dfsAndValidRange.isValidBST(root2);
        System.out.println(result2);
    }
}
