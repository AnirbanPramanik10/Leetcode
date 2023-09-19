class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (k >= n / 2) {
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }

        int[][][] dp = new int[n][k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return helper(prices, 0, k, 0, dp);
    }

    public int helper(int[] prices, int i, int k, int open, int[][][] dp) {
        if (k == 0 || i == prices.length) {
            return 0;
        }

        if (dp[i][k][open] != -1) {
            return dp[i][k][open];
        }

        if (open == 0) {
            return dp[i][k][open] = Math.max(helper(prices, i + 1, k, open, dp), helper(prices, i + 1, k, 1 - open, dp));
        } else {
            return dp[i][k][open] = (prices[i] - prices[i - 1]) + Math.max(helper(prices, i + 1, k, open, dp), helper(prices, i + 1, k - 1, 1 - open, dp));
        }
    }
}
