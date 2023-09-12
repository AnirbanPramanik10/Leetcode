class Solution {
    public String pushDominoes(String dominoes) {
        String[] line = dominoes.split("");
        int[] res = new int[line.length];
        int maxForce = dominoes.length();

        int curr = 0;
        for (int i = 0; i < line.length; i++) {
            if (line[i].equals("R")) curr = maxForce;
            else if (line[i].equals(".")) curr = Math.max(curr - 1, 0);
            else curr = 0;
            res[i] += curr;
        }

        curr = 0;
        for (int i = line.length - 1; i >= 0; i--) {
            if (line[i].equals("L")) curr = maxForce;
            else if (line[i].equals(".")) curr = Math.max(curr - 1, 0);
            else curr = 0;
            res[i] -= curr;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < line.length; i++) {
            if (res[i] > 0) sb.append("R");
            else if (res[i] < 0) sb.append("L");
            else sb.append(".");
        }
        return sb.toString();
    }
}