class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> newMap = new HashMap<>();

        for (char C : s1.toCharArray()) {
            map.put (C, map.getOrDefault(C, 0) + 1);
        }

        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            
            String subString = s2.substring(i, i + s1.length());

            for (char S : subString.toCharArray()) {
                newMap.put (S, newMap.getOrDefault(S, 0) + 1);
            }
            
            if (map.equals(newMap)) return true;
            else newMap.clear();
        }
        return false;
    }
}