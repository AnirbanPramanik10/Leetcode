class Solution {
    public boolean exist(char[][] b, String w) {
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                if (dfs(b, i, j, 0, w)) return true;
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] b, int i, int j, int idx, String w) {
        if (idx == w.length()) return true;
        if (i < 0 || j < 0 || i >= b.length || j >= b[0].length || b[i][j] != w.charAt(idx)) return false;
        
        char orig = b[i][j];
        b[i][j] = '*';
        
        boolean found = dfs(b, i + 1, j, idx + 1, w) ||
                        dfs(b, i - 1, j, idx + 1, w) ||
                        dfs(b, i, j + 1, idx + 1, w) ||
                        dfs(b, i, j - 1, idx + 1, w);
            
        b[i][j] = orig;
        
        return found;
    }
}
