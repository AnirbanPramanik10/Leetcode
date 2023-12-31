class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        if (n == 0) return -1;

        int[] prefixSum = new int[n];
        int[] suffixSum = new int[n];

        prefixSum[0] = nums[0];
        suffixSum[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
            suffixSum[n - 1 - i] = suffixSum[n - i] + nums[n - 1 - i];
        }

        for (int i = 0; i < n; i++) {
            if (prefixSum[i] == suffixSum[i]) return i;
        }

        return -1;
    }
}
