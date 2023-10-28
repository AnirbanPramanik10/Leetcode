class Solution {
    public int countVowelPermutation(int n) {
        if (n == 1) return 5;
    
        long mod = 1_000_000_007;
        long a = 1, e = 1, i = 1, o = 1, u = 1;
        long a1 = 0, e1 = 0, i1 = 0, o1 = 0, u1 = 0;
        for (int j = 1; j < n; j++) {
            a1 = (e + i + u) % mod;
            e1 = (a + i) % mod;
            i1 = (e + o) % mod;
            o1 = i;
            u1 = (i + o) % mod;
            a = a1;
            e = e1;
            i = i1;
            o = o1;
            u = u1;
        }
        return (int) ((a + e + i + o + u) % mod);
    }
}