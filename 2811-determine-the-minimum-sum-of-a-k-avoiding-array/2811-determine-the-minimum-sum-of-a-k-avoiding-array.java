 class Solution {
    public int minimumSum(int n, int k) {
        int res = 0, count = 0;
        for (int i = 1; i <= n; i++) {
            if (i + i - 1 >= k) {
                count = i - 1;
                break;
            }
            res += i;
            if (i == n) return res;
        }
        for (int i = count + 1; i <= n; i++) {
            res += k++;
        }
        return res;
    }
}
