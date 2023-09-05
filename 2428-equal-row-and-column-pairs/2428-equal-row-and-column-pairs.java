class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int count = 0;
        for(int j = 0; j < n; j++) {
            int[] t = new int[grid.length];
            for(int i = 0 ; i < grid[j].length; i++) 
                t[i] = grid[i][j];     

            for(int i = 0 ; i < grid.length; i++) {
                if(Arrays.equals(t, grid[i])) {
                    count++;
                }
            }
        }
        return count;
    }
}