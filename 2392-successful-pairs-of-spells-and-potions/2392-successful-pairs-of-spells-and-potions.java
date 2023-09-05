class Solution {
    public int[] successfulPairs(int[] s, int[] p, long success) {
        Arrays.sort(p);
        int res[] = new int[s.length];

        for(int i=0;i<s.length;i++){
            int l = 0, r = p.length;
            while(l<r){
                int m = l+(r-l)/2;
                if((long)p[m]*s[i]<success) l = m+1;
                else r = m;
            }
            res[i] = p.length-l;
        }
        return res;
    }
}