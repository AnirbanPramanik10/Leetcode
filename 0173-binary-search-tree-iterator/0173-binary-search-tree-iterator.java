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
class BSTIterator {
    TreeNode root;

    public BSTIterator(TreeNode root) {
        TreeNode front = new TreeNode(0);
        toList(root, front).right = null;
        this.root = front.right;
    }

    private TreeNode toList(TreeNode root, TreeNode last) {
        TreeNode l = root.left, r = root.right;
        if (l != null) toList(l, last).right = root;
        else last.right = root;    
        if (r != null) return toList(r, root);
        else return root;
    }
    
    public int next() {
        int res = root.val;
        root =root.right;
        return res;
    }
    
    public boolean hasNext() {
        return (root != null);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */