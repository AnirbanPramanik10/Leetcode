class Solution {
    public long dividePlayers(int[] skill) {
        int sum = 0;
        int max = 0;
        for(int x : skill) {
            sum += x;
            if(x > max) max = x;
        }
        if(sum % (skill.length/2) != 0) return -1;
        int teamVal = sum / (skill.length/2);
        if(teamVal <= max) return -1;
        long[] counts = new long[teamVal];
        for(int x : skill) {
            counts[x]++;
        }
        //System.out.println(Arrays.toString(counts));
        long ret = 0;
        for(int i = 1; i <= (teamVal/2); i++) {
            if(counts[i] == counts[teamVal - i]) {
                ret += counts[i]*i*(teamVal-i);
            }
            else return -1;
            //System.out.println(ret);
        }
        if(teamVal % 2 == 0) ret -= counts[teamVal/2]*teamVal/2*(teamVal/2)/2;
        return ret;
    }
}