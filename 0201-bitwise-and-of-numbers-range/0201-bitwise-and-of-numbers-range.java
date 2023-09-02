class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int base = 1;
        while (left != right) {
            left /= 2;
            right /= 2;
            base *= 2;
        }
        return left * base;
    }
}