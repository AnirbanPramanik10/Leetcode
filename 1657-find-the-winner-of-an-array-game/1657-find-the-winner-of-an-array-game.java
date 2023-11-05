class Solution {
    public int getWinner(int[] arr, int k) {
        int current = arr[0], consecutiveWins = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > current) {
                current = arr[i];
                consecutiveWins = 1;
            } 
            else consecutiveWins++;

            if (consecutiveWins == k) return current;
        }
        return current;
    }
}
