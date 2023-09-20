class Solution {
    public int minOperations(int[] nums, int x) {
        int target=-x;
        for(int i=0;i<nums.length;i++){
            target+=nums[i];
        }
        if(target==0) return nums.length;
        HashMap<Integer,Integer> hs=new HashMap<>();
        int sum=0,res=-1;
        hs.put(0,-1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(hs.containsKey(sum-target)){
                res=Math.max(res,i-hs.get(sum-target));
            }
            hs.put(sum,i);
        }
        return res==-1?-1:nums.length-res;
    }
}