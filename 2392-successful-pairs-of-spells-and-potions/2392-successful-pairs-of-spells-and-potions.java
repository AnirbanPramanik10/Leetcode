class Solution {
    public int ans[];
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        ans = new int[spells.length];
        for(int i = 0; i < spells.length; i++){
            binary(spells[i], potions, success, i);
        }
        return ans;
    }

    public void binary(int spell, int potions[], long success, int idx){
        int l = 0, r = potions.length - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            long product = (long) spell * potions[mid];
            if(product >= success){
                // System.out.println(potions[mid]);
                // ans[idx] = potions.length - l; 
                r = mid - 1;
                // return;
            }
            else l = mid + 1;
        }
        ans[idx] = potions.length - l;
    }
}