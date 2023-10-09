class Solution {
    public String optimalDivision(int[] nums) {
        int n = nums.length;
        if (n == 1) return Integer.toString(nums[0]);
        else if (n == 2) return nums[0] + "/" + nums[1];
        else {
            StringBuilder result = new StringBuilder();
            result.append(nums[0]);
            result.append("/(");
            for (int i = 1; i < n; i++) {
                result.append(nums[i]);
                if (i < n - 1) {
                    result.append("/");
                }
            }
            result.append(")");
            return result.toString();
        }
    }
}
