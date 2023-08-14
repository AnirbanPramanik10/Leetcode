class Solution {
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int maxDiff = 0;
        int val = 0;
        for(int i=0;i<nums.length-1;i++){
            val = nums[i+1] - nums[i];
            if(val > maxDiff){
                maxDiff = val;
            }
        }
        return maxDiff;
    }
}