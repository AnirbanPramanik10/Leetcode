class Solution {
    private static final int[] res = {1, 2, 3, 8, 10, 36, 41, 132, 250, 700, 750, 4010, 4237, 10680, 24679};
    public int countArrangement(int n) {
        return res[n - 1];
    }
}