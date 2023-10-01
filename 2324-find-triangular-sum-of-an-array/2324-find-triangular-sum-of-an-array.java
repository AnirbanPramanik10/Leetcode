class Solution {
    public int triangularSum(int[] nums) {
        while (nums.length > 1) {
            int n = nums.length;
            for (int i = 0; i < n - 1; i++) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
            nums = Arrays.copyOf(nums, n - 1);
        }
        return nums[0];
    }
}
