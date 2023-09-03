class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list=new ArrayList<>();
        int start=0, end=0;
        int char1[]=new int[26];
        int char2[]=new int[26];

        for(int i=0;i<p.length();i++)
            char2[p.charAt(i)-'a']++;
        
        for(end=0;end<s.length();end++){
            char1[s.charAt(end)-'a']++; 
            if(end>=p.length()) char1[s.charAt(start++)-'a']--;
            if(Arrays.equals(char2,char1)) list.add(start);
            }
        return list;
    }
}