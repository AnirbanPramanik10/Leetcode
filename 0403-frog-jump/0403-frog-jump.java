class Solution {
    public boolean canCross(int[] stones) {
        HashMap<Integer,HashSet<Integer>> hmap = new HashMap<>();
        for(int i=0;i<stones.length;i++)
            hmap.put(stones[i] , new HashSet<>());
        
        hmap.get(stones[0]).add(1);

        for(int i=0;i<stones.length;i++){
            int currStone = stones[i];
            HashSet<Integer> jumps = hmap.get(currStone);
            for(int jump : jumps){
                int pos = currStone + jump;
                if(pos == stones[stones.length - 1])return true;

                if(hmap.containsKey(pos) == true){
                    if(jump-1 > 0)
                        hmap.get(pos).add(jump-1);
                    hmap.get(pos).add(jump);
                    hmap.get(pos).add(jump+1);
                }
            }
        }
        return false;
    }
}