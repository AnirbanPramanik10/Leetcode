class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int count = 0, end = Integer.MIN_VALUE;
        
        for (int[] pair : pairs) {
            if (end < pair[0]) {
                end = pair[1];
                count++;
            }
        }
        return count;
    }
}
