class Solution {
    public long solve(int i,int j,int k,int x,int n,long[][] dp){
        if(i==0 && j==0) return 1;
        if(i==0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];

        if(i<=k){
            long y = (solve(i-1,j-1,k,x,n,dp)*j)%x;
            //System.out.println(i+" "+j+" "+y);
            return dp[i][j]=y;
        }
        else{
            long count1 = (solve(i-1,j-1,k,x,n,dp)*j)%x;
            long count2 = (solve(i-1,j,k,x,n,dp)*(n-j))%x;
            //System.out.println(i+" "+j+" "+(count1+count2));
            return dp[i][j]=(count1 + count2)%x;
        }
    }
    
    public int numMusicPlaylists(int n, int goal, int k) {
        long ans;
        int x = 1000000007;
        long[][] dp = new long[goal+1][n+1];
        
        for(int i=0;i<goal+1;i++){
            Arrays.fill(dp[i],-1);
        }    
        return (int)solve(goal,n,k,x,n,dp);
    }
}