class Solution {
    public boolean winnerOfGame(String colors) {
        int countA = 0, countB = 0;

        for(int i=1; i<colors.length() - 1; i++) {
            if(colors.charAt(i) == 'A') {
                if(colors.charAt(i-1) == 'A' && colors.charAt(i+1) == 'A')
                    countA++;
            } else {
                if(colors.charAt(i-1) == 'B' && colors.charAt(i+1) == 'B')
                    countB++;
            }
        }
        if(countA > countB) return true;
        else return false;
    }
}