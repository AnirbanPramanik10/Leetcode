class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 9;

        int uniqueDigits = 9;
        for (int i = 2; i <= n && uniqueDigits > 0; i++) {
            dp[i] = dp[i - 1] * uniqueDigits;
            uniqueDigits--;
        }

        int result = 0;
        for (int count : dp) {
            result += count;
        }
        return result;
    }
}
