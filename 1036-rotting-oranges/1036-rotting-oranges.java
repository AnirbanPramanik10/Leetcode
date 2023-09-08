class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int freshOrange = 0;
        LinkedList<int[]> rottenQueue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    rottenQueue.add(new int[]{i, j});
                }
                if (grid[i][j] == 1)
                    freshOrange++;
            }
        }
        
        int toRotTime = -1;
        while (!rottenQueue.isEmpty()) {
            toRotTime++;
            int size = rottenQueue.size();
            for (int x = 0; x < size; x++) {
                int[] toRot = rottenQueue.poll();
                int i = toRot[0];
                int j = toRot[1];
                if (i < m - 1 && grid[i + 1][j] == 1) {
                    grid[i + 1][j] = 2;
                    rottenQueue.add(new int[]{i + 1, j});
                    freshOrange--;
                }
                if (i > 0 && grid[i - 1][j] == 1) {
                    grid[i - 1][j] = 2;
                    rottenQueue.add(new int[]{i - 1, j});
                    freshOrange--;
                }
                if (j < n - 1 && grid[i][j + 1] == 1) {
                    grid[i][j + 1] = 2;
                    rottenQueue.add(new int[]{i, j + 1});
                    freshOrange--;
                }
                if (j > 0 && grid[i][j - 1] == 1) {
                    grid[i][j - 1] = 2;
                    rottenQueue.add(new int[]{i, j - 1});
                    freshOrange--;
                }
            }
        }
        
        return freshOrange > 0 ? -1 : (toRotTime == -1 ? 0 : toRotTime);
    }
}
