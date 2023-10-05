class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        int n = nums.length;

        for(int i=0;i<n;i++)
            hmap.put(nums[i],hmap.getOrDefault(nums[i],0)+1);

        for(int i=0;i<nums.length;i++)
            if(hmap.get(nums[i])>nums.length/3) set.add(nums[i]);
        
        for(Integer val : set) 
            list.add(val);
            
        return list;
    }
}