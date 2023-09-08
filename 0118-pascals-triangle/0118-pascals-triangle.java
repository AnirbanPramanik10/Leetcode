class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=1;i<=numRows;i++)list.add(NCR(i));
        return list;
    }

    private List<Integer> NCR(int row){
        long ans = 1;
        ArrayList<Integer> list = new ArrayList<>();
        list.add((int)ans);
        for(int col=1;col<row;col++){
            ans = (ans * (row-col));
            ans /= col;
            list.add((int)ans);
        }
        return list;
    }  
}