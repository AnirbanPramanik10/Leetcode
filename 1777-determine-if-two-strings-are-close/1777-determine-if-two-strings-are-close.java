class Solution {
    public boolean closeStrings(String x, String y) {
        if(x.length()!=y.length()) return false;
        int frq1[] = new int[26];
        int frq2[] = new int[26];
        Set<Character> s1 = new HashSet<>();
        Set<Character> s2 = new HashSet<>();
        for(char ch : x.toCharArray()){
            frq1[ch-'a']++;
            s1.add(ch);
        }
        for(char ch : y.toCharArray()){
            frq2[ch-'a']++;
            s2.add(ch);
        }
        Arrays.sort(frq1);
        Arrays.sort(frq2);
        return Arrays.equals(frq1,frq2) && s1.equals(s2);
    }
}