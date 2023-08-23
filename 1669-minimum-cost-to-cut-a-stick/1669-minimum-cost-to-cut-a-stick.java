class Solution {
    public int minCost(int n, int[] cuts) {
        int[] temp = new int[cuts.length + 2];
        System.arraycopy(cuts, 0, temp, 1, cuts.length);
        temp[temp.length - 1] = n;
        Arrays.sort(temp);

        int[][] dp = new int[temp.length][temp.length];

        for (int len = 2; len < temp.length; len++)
            for (int i = 0; i + len < temp.length; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++)
                    dp[i][j] = Math.min(dp[i][j], temp[j] - temp[i] + dp[i][k] + dp[k][j]);
            }

        return dp[0][temp.length - 1];
    }
}
