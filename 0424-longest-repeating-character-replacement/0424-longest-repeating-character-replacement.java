class Solution {
    public int characterReplacement(String s, int k) {
        int[] charCount = new int[26];
        int maxLength = 0, maxFrequency = 0, i = 0, j = 0;

        for (j = 0; j < s.length(); j++) {
            maxFrequency = Math.max(maxFrequency, ++charCount[s.charAt(j) - 'A']);  
            while (j - i + 1 - maxFrequency > k) {
                charCount[s.charAt(i++) - 'A']--;
            }   
            maxLength = Math.max(maxLength, j - i + 1);
        } 
        return maxLength;
    }
}
