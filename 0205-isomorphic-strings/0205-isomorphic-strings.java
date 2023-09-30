class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        Map<Character, Character> mapping = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            
            if (mapping.containsKey(charS)) {
                if (mapping.get(charS) != charT) {
                    return false;
                }
            } else {
                if (mapping.containsValue(charT)) {
                    return false;
                }
                mapping.put(charS, charT);
            }
        }
        return true;
    }
}
