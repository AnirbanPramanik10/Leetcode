class Solution {
    public int bestClosingTime(String customers) {
        int hour=0, closePenalty=0, openPenalty=0, n=customers.length();
        
        for(int i=0; i<n; i++) {
            if (customers.charAt(i) == 'Y') closePenalty++;
        }
        int penalty = openPenalty + closePenalty;
        for(int i=1; i<=n; i++) {
            if (customers.charAt(i-1) == 'N')openPenalty++;
            if (customers.charAt(i-1) == 'Y')closePenalty--;
            if (openPenalty + closePenalty < penalty) {
                penalty = openPenalty + closePenalty;
                hour = i;
            }
        }
        return hour;
    }
}