class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        
        StringBuilder[] rows = new StringBuilder[Math.min(s.length(), numRows)];
        for (int i = 0; i < rows.length; i++) rows[i] = new StringBuilder();
        
        int currentRow = 0, step = 1;
        
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);
            if (currentRow == 0) step = 1;
            else if (currentRow == numRows - 1) step = -1;
            currentRow += step;
        }
        
        return String.join("", rows);
    }
}
