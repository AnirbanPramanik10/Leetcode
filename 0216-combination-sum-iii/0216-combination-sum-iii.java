class Solution {
    List<List<Integer>> ll = new ArrayList<>();
    List<Integer> l = new ArrayList<>();
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        helper(k,n,1);
        return ll;
    }

    private void helper(int k, int n, int st){
        if(k == 0 && n == 0){
            ll.add(new ArrayList<>(l));
            return;
        }

        for(int i=st;i<10;i++){
            l.add(i);
            helper(k-1,n-i,i+1);
            l.remove(l.size()-1);
        }
    }
}