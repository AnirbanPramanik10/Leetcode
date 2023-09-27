class Solution {
    public int triangleNumber(int[] nums) {
        if (nums.length < 3) return 0;
        Arrays.sort(nums);
        int numValid = 0;
        for (int i=0; i<nums.length - 2; i++) {
            for (int j=i+1;j<nums.length -1; j++) {
                for (int k=j+1; k< nums.length; k++) {
                    if (isValidTriangle(nums[i], nums[j], nums[k])) numValid++;
                    else break;
                }
            }
        }
        return numValid;
    }
    
    private boolean isValidTriangle(int a, int b, int c) {
        // if (a <=0 || b <= 0 || c<=0) {
        //     return false;
        // }
        if (a + b <= c || b+c <= a || a+c <= b) {
            return false;
        }
        return true;
    }
}