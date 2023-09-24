class Solution {
    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        boolean[] col = new boolean[n];
        boolean[] diagonal1 = new boolean[2 * n - 1];
        boolean[] diagonal2 = new boolean[2 * n - 1];
        int count = 0;
        int ans = nQueens(board, col, diagonal1, diagonal2, 0);
        return ans;
    }
    
    public int nQueens(boolean[][] board, boolean[] col, boolean[] d1, boolean[] d2, int i){
        if(i == board.length){
            return 1;
        }
        
        int count = 0;
        
        for(int j = 0; j < board[0].length; j++){
            if(col[j] == false && d1[i + j] == false && d2[(i-j) + (board.length - 1)] == false){
                col[j] = true;
                d1[i + j] = true;
                d2[(i-j) + (board.length - 1)] = true;
                count += nQueens(board, col, d1, d2, i + 1);
                col[j] = false;
                d1[i + j] = false;
                d2[(i-j) + (board.length - 1)] = false;
            }
        }
        
        return count;
    }
}