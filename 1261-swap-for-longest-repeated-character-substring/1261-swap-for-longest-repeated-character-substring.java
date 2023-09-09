class Solution {
    public int maxRepOpt1(String text) {
        int[] freq = new int[26];
        char[] arr = text.toCharArray();
        
        for (int i=0; i < arr.length; i++) {
            freq[arr[i]-'a']++;
        }
        
        int max = 0;
        for (int i=0; i < arr.length; i++) {
            char curr = arr[i];
            int j = i, count = 0, diff = 0;
            while (j < arr.length && (curr == arr[j] || diff == 0) && count < freq[curr-'a']) {
                if (curr != arr[j]) ++diff;
                ++count;
                ++j;
            }
            if (count < freq[arr[i]-'a'] && diff == 0) count++;
            max = Math.max(max, count);
        }
        return max;
    }
}
