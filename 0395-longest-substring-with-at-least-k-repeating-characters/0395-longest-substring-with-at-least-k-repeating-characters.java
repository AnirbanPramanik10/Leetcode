class Solution {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        if (n == 0 || n < k) return 0;
        if (k <= 1) return n;
        
        int[] freq = new int[26]; 
        
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        int p = 0;
        while (p < n && freq[s.charAt(p) - 'a'] >= k) p++;
        
        if (p >= n - 1) return p;
        
        int left = longestSubstring(s.substring(0, p), k);
        int right = longestSubstring(s.substring(p + 1), k);
        
        return Math.max(left, right);
    }
}
