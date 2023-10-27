class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int start = 0, end = 0;
        boolean dp[][] = new boolean[n][n];

        for(int k=0;k<n;k++){
            for(int i=0,j=k;j<n;j++,i++){
                if(k == 0){
                    dp[i][j] = true;
                }else if(k == 1){
                    if(s.charAt(i) == s.charAt(j))
                        dp[i][j] = true;
                    else 
                        dp[i][j] = false;
                }else{
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = false;
                    }
                }
                if (dp[i][j]) {
                    start = i;
                    end = j;
                }
            }        
        }
        return s.substring(start, end + 1);
    }
}