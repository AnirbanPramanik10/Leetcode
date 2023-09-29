class Solution {
    public boolean canTransform(String start, String end) {
        if (!start.replace("X", "").equals(end.replace("X", ""))) return false;
        int p1 = 0, p2 = 0, n = start.length();

        while (p1 < n && p2 < n) {
            while (p1 < n && start.charAt(p1) == 'X') p1++;
            while (p2 < n && end.charAt(p2) == 'X') p2++;

            if (p1 == n && p2 == n) return true;
            if (p1 == n || p2 == n || start.charAt(p1) != end.charAt(p2)) return false;
            if ((start.charAt(p1) == 'L' && p1 < p2) || (start.charAt(p1) == 'R' && p1 > p2)) return false;
            
            p1++;
            p2++;
        }
        return true;
    }
}
