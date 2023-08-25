class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length())return false;
        return Interleaving(s1,s2,s3,0,0,new Boolean [s1.length()+1][s2.length()+1]);
    }

    private boolean Interleaving(String s1, String s2, String s3, int i, int j,Boolean [][]dp){
        if(i + j == s3.length())return true;
        if(dp[i][j]!=null) return dp[i][j];

        if(i < s1.length() && s3.charAt(i+j) == s1.charAt(i)){
            boolean ans = Interleaving(s1,s2,s3,i+1,j,dp);
            dp[i][j] = ans;
            if(ans)return true;
        }

        if(j < s2.length() && s3.charAt(i+j) == s2.charAt(j)){
            boolean ans = Interleaving(s1,s2,s3,i,j+1,dp);
            dp[i][j] = ans;
            if(ans)return true;
        }
        dp[i][j] = false;
        return false;
    }
}