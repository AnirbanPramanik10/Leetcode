class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        int count = 1 , i = 0 , j = 1;
        while (j < pairs.length) {
            if (pairs[i][1] < pairs[j][0]) {
                count++;
                i = j;
            } else j++;
        }
        return count;
    }
}