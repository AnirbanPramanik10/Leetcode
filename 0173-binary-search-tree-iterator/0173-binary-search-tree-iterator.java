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
    TreeNode base;
    ArrayList<Integer> al = new ArrayList<>();
    int max = 0;
    public BSTIterator(TreeNode root) {
        base = root;
        base = inorder(base);
        max = al.size();
    }
    
    public int next() {
       int temp = al.get(0);
       al.remove(0);
       return temp;
    }
    
    public boolean hasNext() {
        if(al.size()>0)
            return true;
        
        return false;
    }

    public TreeNode inorder(TreeNode root){
        if(root==null)
            return null;
        
        inorder(root.left);
        al.add(root.val);
        inorder(root.right);

        return root;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */