class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int ind = 1;
        for(int num : target){
            while(ind < num){
                ans.add("Push");
                ans.add("Pop");
                ind++;
            }
            ans.add("Push");
            ind++;
        }

        return ans;
    }
}