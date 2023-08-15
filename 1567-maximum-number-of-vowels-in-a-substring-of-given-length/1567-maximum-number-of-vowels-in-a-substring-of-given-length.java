class Solution { 
    public int maxVowels(String s, int k) {
        int n = s.length(), ans = 0, max = 0;
        for(int i=0; i<k; i++)
            ans+=isVowel(s.charAt(i));
        max = ans;
        for(int i=1; i<=n-k; i++){
            ans = ans - isVowel(s.charAt(i-1)) + isVowel(s.charAt(i+k-1));
            max = Math.max(max,ans);
        }
        return max;
    }
    public int isVowel(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'u' || c == 'o') return 1;
        return 0;
    }
}