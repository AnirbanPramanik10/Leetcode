class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currentBalance = 0, totalBalance = 0, startIndex = 0;
        
        for (int i = 0; i < gas.length; i++) {
            currentBalance += gas[i] - cost[i];
            totalBalance += gas[i] - cost[i];
            
            if (currentBalance < 0) {
                startIndex = i + 1;
                currentBalance = 0;
            } 
        }
        return totalBalance >= 0 ? startIndex : -1;
    }
}
