class Solution {
    public int findMaxLength(int[] nums) {
        int length = nums.length, currentSum = length, maxLength = 0;
        int[] sumIndexMap = new int[2 * length + 2];

        for (int i = 0; i < length; i++) {
            currentSum += (nums[i] << 1) - 1;

            if (currentSum == length) maxLength = i + 1;
            else if (sumIndexMap[currentSum] == 0) sumIndexMap[currentSum] = i + 1;
            else maxLength = Math.max(maxLength, i - sumIndexMap[currentSum] + 1);
        }
        return maxLength;
    }
}
