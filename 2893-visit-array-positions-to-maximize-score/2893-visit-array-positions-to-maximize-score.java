class Solution {
    public long maxScore(int[] nums, int x) {
        long evenSum = nums[0], oddSum = nums[0], n = nums.length;
        
        if (nums[0] % 2 == 0) oddSum -= x;
        else evenSum -= x;
        
        for (int i = 1; i < n; i++) {
            if (nums[i] % 2 == 0) {
                evenSum = Math.max(evenSum + nums[i], oddSum + nums[i] - x);
            } else {
                oddSum = Math.max(oddSum + nums[i], evenSum + nums[i] - x);
            }
        }
        return Math.max(evenSum, oddSum);
    }
}
