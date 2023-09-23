class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> (a.length() - b.length()));
        Map<String, Integer> map = new HashMap<>(); 
        int res = 0;
        for (String w : words){
            int cnt = 0; 
            for (int i = 0; i<w.length(); i++){
                String t = w.substring(0, i) + w.substring(i+1);
                int tchain = map.getOrDefault(t, 0);
                cnt = Math.max(cnt, tchain+1);
            }
            map.put(w, cnt);
            res = Math.max(res, cnt);
        }
        return res;
    }
}