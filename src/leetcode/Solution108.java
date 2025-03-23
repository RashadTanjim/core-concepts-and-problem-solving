package leetcode;

import leetcode.helper.TreeNode;

public class Solution108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return constructBST(nums, 0, nums.length - 1);
    }

    private TreeNode constructBST(int[] nums, int left, int right) {
        // Base case: If left > right, return null
        if (left > right) {
            return null;
        }

        // Select the middle element as root
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        // Recursively build left and right subtrees
        root.left = constructBST(nums, left, mid - 1);
        root.right = constructBST(nums, mid + 1, right);

        return root;
    }

    // Utility function to print in-order traversal
    public static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    // Driver Code
    public static void main(String[] args) {
        Solution108 sol = new Solution108();
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = sol.sortedArrayToBST(nums);

        System.out.print("In-order Traversal of BST: ");
        printInOrder(root);
    }
}
