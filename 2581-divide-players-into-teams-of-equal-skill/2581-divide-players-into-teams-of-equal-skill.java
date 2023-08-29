class Solution {
    public long dividePlayers(int[] nums) {
        int len = nums.length;
        if (len == 2) return (long) nums[0] * nums[1];
        
        Arrays.sort(nums);
        int minPlusMax = nums[0] + nums[len - 1];
        long result = 0;
        
        for (int i = 0; i < len / 2; i++) {
            if (nums[i] + nums[len - 1 - i] == minPlusMax) {
                result += (long) nums[i] * nums[len - 1 - i];
            } else {
                return -1;
            }
        }
        return result;
    }
}