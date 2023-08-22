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
    public int pathSum(TreeNode root, int targetSum) {
        
        Map<Long, Integer> map = new HashMap<>();
        map.put(0l, 1);
        return dfs(root, 0l, targetSum, map);
        
    }

    private int dfs(TreeNode node, long currSum, int target, Map<Long, Integer> map){

        if(node == null)return 0;
        currSum += node.val;
        int count = 0;
        
        // if(map.containsKey(target - currSum)){
        //     count += map.get(target - currSum);
        // }
        // 
    //    else 
       if(map.containsKey(currSum - target)){
            count += map.get(currSum - target);
        }
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        count += dfs(node.left, currSum, target, map) + dfs(node.right, currSum, target, map);
        map.put(currSum, map.get(currSum) - 1);

        // System.out.println("node.val : " + node.val +" count : " + count + " currSum : " + currSum + " map : " + map);
        return count; 

    }
}