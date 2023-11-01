/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private TreeNode prev;
    private int currentCount;
    private int maxCount;
    private List<Integer> modes;

    public int[] findMode(TreeNode root) {
        prev = null;
        currentCount = 0;
        maxCount = 0;
        modes = new ArrayList<Integer>();

        inorderTraversal(root);

        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }

        return result;
    }

    private void inorderTraversal(TreeNode node) {
        if (node == null) return;

        inorderTraversal(node.left);

        if (prev != null && prev.val == node.val) {
            currentCount++;
        } else {
            currentCount = 1;
        }

        if (currentCount > maxCount) {
            maxCount = currentCount;
            modes.clear();
            modes.add(node.val);
        } else if (currentCount == maxCount) {
            modes.add(node.val);
        }

        prev = node;

        inorderTraversal(node.right);
    }
}
