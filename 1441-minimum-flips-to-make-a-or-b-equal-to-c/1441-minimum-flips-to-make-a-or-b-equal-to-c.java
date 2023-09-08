class Solution {
    public int minFlips(int a, int b, int c) {
        if ((a | b) == c) return 0;

        int flip = 0;

        String a1 = Integer.toBinaryString(a);
        String b1 = Integer.toBinaryString(b);
        String c1 = Integer.toBinaryString(c);

        int n = Math.max(a1.length(), Math.max(b1.length(), c1.length()));

        a1 = leftPad(a1, n);
        b1 = leftPad(b1, n);
        c1 = leftPad(c1, n);

        for (int i = c1.length() - 1; i >= 0; i--) {
            if (c1.charAt(i) == '0') {
                if (a1.charAt(i) == '1') {
                    flip++;
                }
                if (b1.charAt(i) == '1') {
                    flip++;
                }
            } else {
                if (a1.charAt(i) == '0' && b1.charAt(i) == '0') {
                    flip++;
                }
            }
        }
        return flip;
    }

    private String leftPad(String s, int n) {
        s = "00000000000000000000000000000000" + s;
        return s.substring(s.length() - n, s.length());
    }
}