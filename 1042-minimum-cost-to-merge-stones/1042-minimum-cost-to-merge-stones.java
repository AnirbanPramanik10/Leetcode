class Solution {
    public int mergeStones(int[] stones, int K) {
        int N = stones.length;
        if ((N - 1) % (K - 1) != 0) return -1;
        
        int[] prefixSum = new int[N + 1];
        for (int i = 0; i < N; i++) prefixSum[i + 1] = prefixSum[i] + stones[i];
        
        int[][] dp = new int[N][N];
        for (int len = K; len <= N; len++)
            for (int i = 0; i <= N - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int m = i; m < j; m += K - 1)
                    dp[i][j] = Math.min(dp[i][j], dp[i][m] + dp[m + 1][j]);
                if ((len - 1) % (K - 1) == 0) dp[i][j] += prefixSum[j + 1] - prefixSum[i];
            }
        return dp[0][N - 1];
    }
}
