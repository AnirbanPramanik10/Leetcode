class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int gcdLength = gcd(len1, len2);

        String sub1 = str1.substring(0, gcdLength);
        String sub2 = str2.substring(0, gcdLength);

        if (sub1.equals(sub2)) {
            String candidate = str1.substring(0, gcdLength);
            if (isDivisible(str1, candidate) && isDivisible(str2, candidate)) {
                return candidate;
            }
        }

        return "";
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private boolean isDivisible(String str, String candidate) {
        int len = str.length();
        int candidateLen = candidate.length();
        StringBuilder sb = new StringBuilder();

        while (sb.length() < len) {
            sb.append(candidate);
        }

        return sb.toString().equals(str);
    }
}
