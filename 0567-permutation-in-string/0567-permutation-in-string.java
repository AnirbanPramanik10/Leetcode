class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] map = new int[128];

        for (char ch : s1.toCharArray()) {
            map[ch]++;
        }

        int start = 0, end = 0, count = s1.length();
        char[] data = s2.toCharArray();

        while (end < data.length) {
            if (map[data[end++]]-- > 0) {
                count--;
            }

            while (count == 0) {
                if (s1.length() == end - start) {
                    return true;
                }

                if (map[data[start++]]++ == 0) {
                    count++;
                }
            }
        }

        return false;
    }
}
