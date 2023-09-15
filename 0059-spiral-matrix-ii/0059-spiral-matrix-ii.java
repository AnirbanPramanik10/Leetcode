class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        int counter = 1;

        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;

        while (left <= right && top <= bottom) {
            for (int j = left; j <= right; j++) {
                res[top][j] = counter++; 
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                res[i][right] = counter++; 
            }
            right--;
            
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    res[bottom][i] = counter++;
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res[i][left] = counter++;
                }
                left++;
            }
        }

        return res;
    }
}