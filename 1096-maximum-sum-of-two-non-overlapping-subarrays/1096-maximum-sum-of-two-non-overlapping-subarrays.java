class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++)
            sum[i] = sum[i - 1] + nums[i - 1];

        return Math.max(find(sum, firstLen, secondLen), find(sum, secondLen, firstLen));
    }

    private int find(int[] sum, int l1, int l2) {
        int n = sum.length, max = 0, res = 0;
        for (int i = l1; i + l2 < n; i++) {
            max = Math.max(max, sum[i] - sum[i - l1]);
            res = Math.max(res, max + sum[i + l2] - sum[i]);
        }
        return res;
    }
}
