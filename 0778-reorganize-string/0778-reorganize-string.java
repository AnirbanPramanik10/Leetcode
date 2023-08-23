class Solution {
    public String reorganizeString(String s) {
        int[] counts = new int[26];
        char maxFreqChar = '-';
        int maxFreq = 0;

        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
            if (counts[c - 'a'] > maxFreq) {
                maxFreq = counts[c - 'a'];
                maxFreqChar = c;
            }
        }

        if (maxFreq > (s.length() + 1) / 2) {
            return "";
        }

        char[] result = new char[s.length()];
        int index = 0;

        while (counts[maxFreqChar - 'a']-- > 0) {
            result[index] = maxFreqChar;
            index += 2;
        }

        for (int i = 0; i < 26; i++) {
            while (counts[i]-- > 0) {
                if (index >= s.length()) {
                    index = 1;
                }
                result[index] = (char) ('a' + i);
                index += 2;
            }
        }

        return new String(result);
    }
}
