class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();

        prefixSum(matrix);

        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                ans += calculateSubmatrices(matrix, i, j, target, map);
            }
        }

        return ans;
    }

    private void prefixSum(int[][] matrix) {
        for (int[] row : matrix) {
            for (int j = 1; j < row.length; j++) {
                row[j] += row[j - 1];
            }
        }
    }

    private int calculateSubmatrices(int[][] matrix, int start, int end, int target, Map<Integer, Integer> map) {
        int n = matrix.length;
        int sum = 0;
        int count = 0;
        map.clear();
        map.put(0, 1);

        for (int l = 0; l < n; l++) {
            sum += matrix[l][end] - (start > 0 ? matrix[l][start - 1] : 0);
            count += map.getOrDefault(sum - target, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
