class Solution {
    public int maxPoints(int[][] points) {
        if (points.length <= 2) return points.length;
        
        int maxPoints = 2;
        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> slopeCount = new HashMap<>();
            int duplicate = 0;
            int vertical = 0;
            
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                
                int deltaX = points[i][0] - points[j][0];
                int deltaY = points[i][1] - points[j][1];
                
                if (deltaX == 0 && deltaY == 0) {
                    duplicate++;
                } else if (deltaX == 0) {
                    vertical++;
                } else {
                    int gcd = gcd(deltaX, deltaY);
                    String slope = (deltaX / gcd) + "/" + (deltaY / gcd);
                    
                    slopeCount.put(slope, slopeCount.getOrDefault(slope, 0) + 1);
                }
            }
            
            int currentMax = vertical;
            for (int count : slopeCount.values()) {
                currentMax = Math.max(currentMax, count);
            }
            
            currentMax += duplicate + 1;
            maxPoints = Math.max(maxPoints, currentMax);
        }
        
        return maxPoints;
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
