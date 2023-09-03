/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        Queue<Node> Q = new ArrayDeque<>();
        Q.add(root);
        
        while(!Q.isEmpty()){
            int len = Q.size();
            int counter = 0;
            while(counter++<len){
                Node remove = Q.poll(); 
                if(counter<len) remove.next = Q.peek();
                else remove.next = null;
                
                if(remove.left !=null) Q.add(remove.left);
                if(remove.right != null) Q.add(remove.right);
            }
        }
        return root;
    }
}