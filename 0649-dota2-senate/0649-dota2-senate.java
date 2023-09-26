class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            (senate.charAt(i) == 'R' ? radiant : dire).offer(i);
        }
        
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int r = radiant.poll(), d = dire.poll();
            if (r < d) radiant.offer(r + n);
            else dire.offer(d + n);
        }
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}
