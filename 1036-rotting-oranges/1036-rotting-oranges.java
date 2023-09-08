class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int freshOrange = 0; // Used for finding if all the fresh oranges are rotted or not. If not rotted, we return -1 
        LinkedList<int[]> rottenQueue =  new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){ // rotton 
                    rottenQueue.add(new int[]{i,j});
                }
                if(grid[i][j] == 1)
                    freshOrange++;
            }
        }
        int toRotTime = -1; // If not set to -1, initial rotten will be considered as to be rotted in queue
        while(!rottenQueue.isEmpty()){
            toRotTime++;
            int size = rottenQueue.size();
            for(int x =0; x < size; x++) { // At a single time, multiple orange can rot. So to capture that we are using for loop. If not used, toRotTime will return total rotted oranges apart from the initial rotted ones.
                int[] toRot = rottenQueue.poll();
                int i = toRot[0];
                int j = toRot[1];
                if(i < m-1 && grid[i+1][j]==1){ // If Fresh Orange is present at Bottom
                    grid[i+1][j] = 2;
                    rottenQueue.add(new int[]{i+1,j});
                    freshOrange --; 
                }
                if(i > 0 && grid[i-1][j]==1){ // If Fresh Orange is present at Top
                    grid[i-1][j] = 2;
                    rottenQueue.add(new int[]{i-1,j});
                    freshOrange --;
                }   
                if(j < n-1 && grid[i][j+1]==1){ // If Fresh Orange is present at Right
                     grid[i][j+1] = 2;
                    rottenQueue.add(new int[]{i,j+1});
                    freshOrange --;
                }
                if(j > 0 && grid[i][j-1]==1){ // If Fresh Orange is present at Left
                     grid[i][j-1] = 2;
                    rottenQueue.add(new int[]{i,j-1});
                    freshOrange --;
                }
                    
            }
        }
        return freshOrange > 0 ? -1 : (toRotTime == -1 ? 0:toRotTime);
    }
}