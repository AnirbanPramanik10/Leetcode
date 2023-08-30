class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] counts = new int[n + 1];
        
        for (int citation : citations)
            counts[Math.min(citation, n)]++;
        
        int papers = 0;
        for (int h = n; h >= 0; h--) {
            papers += counts[h];
            if (papers >= h) return h;
        }
        return 0;
    }
}
