class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] left = new int[n][n];
        int[][] right = new int[n][n];
        int[][] up = new int[n][n];
        int[][] down = new int[n][n];

        Set<String> minesSet = new HashSet<>();
        for (int[] mine : mines) {
            minesSet.add(mine[0] + "," + mine[1]);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!minesSet.contains(i + "," + j)) {
                    left[i][j] = 1;
                    up[i][j] = 1;
                    if (j > 0) left[i][j] += left[i][j - 1];
                    if (i > 0) up[i][j] += up[i - 1][j];
                }
            }
        }

        int answer = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (!minesSet.contains(i + "," + j)) {
                    right[i][j] = 1;
                    down[i][j] = 1;
                    if (j < n - 1) right[i][j] += right[i][j + 1];
                    if (i < n - 1) down[i][j] += down[i + 1][j];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!minesSet.contains(i + "," + j)) {
                    int order = Math.min(Math.min(left[i][j], right[i][j]), Math.min(up[i][j], down[i][j]));
                    answer = Math.max(answer, order);
                }
            }
        }

        return answer;
    }
}
