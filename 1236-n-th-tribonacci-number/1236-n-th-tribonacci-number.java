public class Solution {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        int[] tribonacciSequence = new int[n + 1];
        tribonacciSequence[0] = 0;
        tribonacciSequence[1] = 1;
        tribonacciSequence[2] = 1;

        for (int i = 3; i <= n; i++) {
            tribonacciSequence[i] = tribonacciSequence[i - 1] + tribonacciSequence[i - 2] + tribonacciSequence[i - 3];
        }

        return tribonacciSequence[n];
    }
}
