class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;
        int count = t.length();

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);

            if (charCountMap.containsKey(rightChar)) {
                charCountMap.put(rightChar, charCountMap.get(rightChar) - 1);

                if (charCountMap.get(rightChar) >= 0) count--;
            }

            while (count == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }

                char leftChar = s.charAt(left);

                if (charCountMap.containsKey(leftChar)) {
                    charCountMap.put(leftChar, charCountMap.get(leftChar) + 1);

                    if (charCountMap.get(leftChar) > 0) count++;
                }
                left++;
            }
        }
        
        if (minLen == Integer.MAX_VALUE) return "";
        return s.substring(minLeft, minLeft + minLen);
    }
}
