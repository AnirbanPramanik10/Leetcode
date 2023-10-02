class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long low = 1;
        long high = (long) 2e9;
        
        while (low < high) {
            long mid = low + (high - low) / 2;
            
            long count = mid / a + mid / b + mid / c
                       - mid / lcm(a, b) - mid / lcm(b, c) - mid / lcm(a, c)
                       + mid / lcm(a, lcm(b, c));
            
            if (count < n) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        return (int) low;
    }
    
    private long lcm(long x, long y) {
        return x * y / gcd(x, y);
    }
    
    private long gcd(long x, long y) {
        while (y != 0) {
            long temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }
}
