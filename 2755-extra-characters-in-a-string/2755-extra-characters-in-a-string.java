class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> ds = new HashSet<>();
        for(var z : dictionary)ds.add(z);
        
        int nums[] = new int[s.length() + 1];
        for(int z=1;z<=s.length();z++){
            nums[z] = nums[z-1]+1;
            for(int y=z;y>=1;y--){
                String anns = s.substring(y-1,z);
                if(ds.contains(anns)) nums[z] = Math.min(nums[z],nums[y-1]);
            }
        }
        return nums[s.length()];
    }
}