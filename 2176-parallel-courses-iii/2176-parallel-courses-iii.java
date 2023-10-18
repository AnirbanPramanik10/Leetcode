class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        int[] inDegree = new int[n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] r : relations) {
            graph[r[0] - 1].add(r[1] - 1);
            inDegree[r[1] - 1]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++)
            if (inDegree[i] == 0) {
                q.offer(i);
                dp[i] = time[i];
            }

        int minTime = 0;
        while (!q.isEmpty()) {
            int course = q.poll();
            minTime = Math.max(minTime, dp[course]);
            for (int nextCourse : graph[course]) {
                inDegree[nextCourse]--;
                dp[nextCourse] = Math.max(dp[nextCourse], dp[course] + time[nextCourse]);
                if (inDegree[nextCourse] == 0) q.offer(nextCourse);
            }
        }

        return minTime;
    }
}
