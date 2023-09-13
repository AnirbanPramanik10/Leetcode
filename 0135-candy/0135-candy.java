public class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        int total = 1, up = 1, down = 0, peak = 1;
        
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i-1]) {
                up++;
                peak = up;
                down = 0;
                total += up;
            } else if (ratings[i] < ratings[i-1]) {
                down++;
                up = 1;
                total += down + (down >= peak ? 1 : 0);
            } else {
                up = 1;
                down = 0;
                total += 1;
                peak = 1;
            }
        }
        return total;
    }
}
