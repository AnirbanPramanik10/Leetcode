class Solution {
    public int combinationSum4(int[] n, int target) {
        int dp[] = new int[target + 1];
        return find(n,target,dp);
    }

    private int find(int n[], int t, int dp[])
    {
        dp[0] = 1;
        for(int i=1;i<=t;i++)
        {
            for(int j=0;j<n.length;j++)
            {
                if(i - n[j] >= 0) dp[i] += dp[i - n[j]];
            }
        }
        return dp[t];
    }
}