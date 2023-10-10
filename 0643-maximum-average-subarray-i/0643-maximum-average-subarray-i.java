class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double maxAverage = Integer.MIN_VALUE;
        double currentSum = 0;

        for (int i = 0; i < n; i++) {
            if (i < k) {
                currentSum += nums[i];
            } else {
                maxAverage = Math.max(maxAverage, currentSum / k);
                currentSum += nums[i] - nums[i - k];
            }
        }
        
        maxAverage = Math.max(maxAverage, currentSum / k);
        
        return maxAverage;
    }
}
