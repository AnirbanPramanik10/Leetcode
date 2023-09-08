class Solution {
    public int minFlips(int a, int b, int c) {
        int ans = 0, i = 0;
        while(i < 65){
            int bita =( a & 1 ) | 0 , bitb =( b & 1) | 0, required =  (c & 1) | 0;
            // System.out.println(bita +" "+ bitb +" "+ required);
            if(required == 0)ans+=bita+bitb;
            else{
                if(bita + bitb == 0) ans++;
            }
            a = a>>1;
            b = b>>1;
            c = c>>1;
            i++;
        }
        return ans;
    }
}