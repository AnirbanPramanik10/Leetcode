class Solution {
    public int characterReplacement(String s, int k) {
        int[] freqs = new int[26];
        int maxLen = 0, maxFreq = 0, left = 0;

        for (int right = 0; right < s.length(); right++) {
            maxFreq = Math.max(maxFreq, ++freqs[s.charAt(right) - 'A']);
            while (right - left + 1 - maxFreq > k) {
                freqs[s.charAt(left++) - 'A']--;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
