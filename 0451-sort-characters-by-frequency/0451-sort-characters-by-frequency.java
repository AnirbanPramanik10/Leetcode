class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        
        List<Character>[] buckets = new List[s.length() + 1];
        for (char ch : freqMap.keySet()) {
            int freq = freqMap.get(ch);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(ch);
        }
        
        StringBuilder ansStr = new StringBuilder();
        for (int freq = s.length(); freq > 0; freq--) {
            if (buckets[freq] != null) {
                for (char ch : buckets[freq]) {
                    for (int i = 0; i < freq; i++) {
                        ansStr.append(ch);
                    }
                }
            }
        }
        return ansStr.toString();
    }
}
