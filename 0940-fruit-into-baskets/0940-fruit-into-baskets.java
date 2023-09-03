class Solution {
    public int totalFruit(int[] fruits) {
        if (fruits == null || fruits.length == 0) return 0; 
        int secondLast = -1, last =  -1, lastCount = 0, currentMax = 0, max = 0;
        
        for (int fruit : fruits) {
            if (fruit == secondLast || fruit == last) currentMax++;
            else currentMax = lastCount + 1; 
            
            if (fruit == last) lastCount += 1;
            else {
                lastCount = 1;
                secondLast = last;
                last = fruit;
            }   
            max = Math.max(max, currentMax);
        } 
        return max;
    }
}
