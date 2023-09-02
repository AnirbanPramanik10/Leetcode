class Solution {
    public int numTilePossibilities(String tiles) {
        HashSet<String> hs = new HashSet<>();
        backtrack(tiles, hs, "", new boolean[tiles.length()]);
        return hs.size() - 1;
    }
    
    public void backtrack(String tiles, HashSet<String> hs, String s, boolean[] visited){
        hs.add(s);
        
        for(int i = 0; i < tiles.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                backtrack(tiles, hs, s + tiles.charAt(i), visited);
                visited[i] = false;
            }
        }
    }
}
