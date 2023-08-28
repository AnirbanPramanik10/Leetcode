class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMostK(nums, goal) - atMostK(nums, goal - 1);
    }

    private int atMostK(int[] nums, int k) {
        if (k < 0) return 0;
        int cnt = 0, i = 0, n = nums.length, sum = 0;
        for (int j = 0; j < n; j++) {
            sum += nums[j];
            while (sum > k) sum -= nums[i++];
            cnt += j - i + 1;
        }
        return cnt;
    }
}
