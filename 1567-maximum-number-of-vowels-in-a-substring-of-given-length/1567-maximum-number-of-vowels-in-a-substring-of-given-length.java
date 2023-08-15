class Solution {
    public int maxVowels(String s, int k) {
        int currentVowelCount = 0, maxVowelCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) 
                currentVowelCount++;
            
            if (i >= k && isVowel(s.charAt(i - k))) 
                currentVowelCount--;

            maxVowelCount = Math.max(maxVowelCount, currentVowelCount);
        }
        return maxVowelCount;
    }

    boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}