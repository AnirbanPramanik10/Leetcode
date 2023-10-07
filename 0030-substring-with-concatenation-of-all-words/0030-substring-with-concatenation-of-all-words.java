class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int wordLength = words[0].length();
        int totalWords = words.length;
        int windowSize = wordLength * totalWords;
        
        Map<String, Integer> wordCount = new HashMap<>();
        
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        for (int i = 0; i < wordLength; i++) {
            int left = i;
            int right = i;
            Map<String, Integer> currentCount = new HashMap<>();
            
            while (right + wordLength <= s.length()) {
                String word = s.substring(right, right + wordLength);
                right += wordLength;
                
                if (wordCount.containsKey(word)) {
                    currentCount.put(word, currentCount.getOrDefault(word, 0) + 1);
                    
                    while (currentCount.get(word) > wordCount.getOrDefault(word, 0)) {
                        String leftWord = s.substring(left, left + wordLength);
                        currentCount.put(leftWord, currentCount.get(leftWord) - 1);
                        left += wordLength;
                    }
                    
                    if (right - left == windowSize) {
                        result.add(left);
                    }
                } else {
                    currentCount.clear();
                    left = right;
                }
            }
        }
        
        return result;
    }
}
