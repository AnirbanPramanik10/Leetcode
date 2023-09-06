class Solution {
    public int maxTurbulenceSize(int[] arr) 
    {
        int n = arr.length;
        int[][] dp = new int[n+1][2];
        if(n == 1) return 1;

        for(int i=1;i<n;i++)
        {
            if(arr[i-1]>arr[i]) dp[i][1]=1+dp[i-1][0];
            else if(arr[i-1]<arr[i]) dp[i][0]=1+dp[i-1][1];
            else{
                dp[i][0]=0;
                dp[i][1]=0;
            }
        }

        int max=Integer.MIN_VALUE;
        for(int i=0;i<=n;i++)
        {
            max=Math.max(max,Math.max(dp[i][0],dp[i][1]));
        }
        return 1 + max;
    }
}