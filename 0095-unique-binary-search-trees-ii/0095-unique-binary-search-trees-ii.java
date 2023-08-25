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
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<TreeNode>();
        return generateTreesHelper(1, n);
    }
    
    List<TreeNode> generateTreesHelper(int start, int end) {
        List<TreeNode> resultList = new ArrayList<TreeNode>();
        if (start > end) {
            resultList.add(null);
            return resultList;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSubtreeList = generateTreesHelper(start, i - 1);
            List<TreeNode> rightSubtreeList = generateTreesHelper(i + 1, end);
            for (TreeNode leftSubtree : leftSubtreeList) {
                for (TreeNode rightSubtree : rightSubtreeList) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftSubtree;
                    root.right = rightSubtree;
                    resultList.add(root);
                }
            }
        }
        return resultList;
    }
}
