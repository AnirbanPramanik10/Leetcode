class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int oneDayCost = dp[i - 1] + costs[0];
            int j = i - 1;

            while (j >= 1 && days[i - 1] - days[j - 1] < 7) {
                j--;
            }
            int sevenDayCost = dp[j] + costs[1];

            while (j >= 1 && days[i - 1] - days[j - 1] < 30) {
                j--;
            }
            int thirtyDayCost = dp[j] + costs[2];

            dp[i] = Math.min(oneDayCost, Math.min(sevenDayCost, thirtyDayCost));
        }

        return dp[n];
    }
}
