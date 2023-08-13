class Solution {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n+1];
        dp[0] = true;

        for(int i=2;i<=n;i++){
            //case 1 : 2 equal elements
            if(nums[i-1] == nums[i-2]){
                dp[i] = dp[i] || dp[i - 2];
            }
            
            //case 2 : 3 equal elements
            if(i>2 && nums[i-1] == nums[i-2] && nums[i-2] == nums[i-3]){
                dp[i] = dp[i] || dp[i-3];
            }

            // case 3 : exactly 3 consecutive increasing elements
            if(i>2 && nums[i-1]-nums[i-2]==1 && nums[i-2]-nums[i-3]==1){
                dp[i] = dp[i] || dp[i-3];
            }
        }
        return dp[n];
    }
}