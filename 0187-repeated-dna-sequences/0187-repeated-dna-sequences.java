class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> hm = new HashMap<>();
        List<String> ans = new ArrayList<>();
        
        for (int i = 0; i <= s.length() - 10; i++) {
            String tem = s.substring(i, i + 10);
            hm.put(tem, hm.getOrDefault(tem, 0) + 1);
        }
        
        for (String str : hm.keySet()) {
            if (hm.get(str) > 1) ans.add(str);
        }
        return ans;
    }
}
