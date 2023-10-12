public class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i <= n / 2; i++) {
            for (int j = 1; Math.max(i, j) <= n - i - j; j++) {
                if (isValid(num, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValid(String num, int i, int j) {
        if ((num.charAt(0) == '0' && i > 1) || (num.charAt(i) == '0' && j > 1)) return false;

        String num1 = num.substring(0, i), num2 = num.substring(i, i + j);
        int start = i + j;

        while (start < num.length()) {
            String sum = String.valueOf(Long.parseLong(num1) + Long.parseLong(num2));
            if (!num.startsWith(sum, start)) return false;
            start += sum.length();
            num1 = num2;
            num2 = sum;
        }

        return true;
    }
}
