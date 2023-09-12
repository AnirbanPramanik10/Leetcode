class Solution {
    public int minDeletions(String s) {
        int ans = 0;
        int[] cnt = new int[26]; 
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        
        Set<Integer> set = new HashSet<>(); 
        for (int freq : cnt) {
            while (freq > 0 && !set.add(freq)) {
                freq--;
                ans++;
            }
        }    
        return ans;
    }
}
