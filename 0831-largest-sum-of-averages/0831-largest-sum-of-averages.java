class Solution {
    public double largestSumOfAverages(int[] nums, int p) {
        int n = nums.length;
        double[] dp = new double[n];
        
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            dp[i] = sum / (i + 1);
        }
        
        for (int i = 1; i < p; i++) {
            double[] next = new double[n];
            for (int j = i; j < n; j++) {
                double sumPartition = 0;
                for (int k = j; k >= i; k--) {
                    sumPartition += nums[k];
                    next[j] = Math.max(next[j], sumPartition / (j - k + 1) + dp[k - 1]);
                }
            }
            dp = next;
        }   
        return dp[n - 1];
    }
}
