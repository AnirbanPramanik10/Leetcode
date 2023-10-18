class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<Integer>[] graph = new List[n + 1];
        int[] minTime = new int[n + 1];

        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        for (int[] relation : relations) graph[relation[1]].add(relation[0]);

        for (int i = 1; i <= n; i++) {
            if (minTime[i] > 0) continue;
            dfs(i, graph, time, minTime);
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, minTime[i]);
        }
        return max;
    }

    private void dfs(int start, List<Integer>[] graph, int[] time, int[] minTime) {
        int max = 0;
        for (int next : graph[start]) {
            if (minTime[next] == 0) dfs(next, graph, time, minTime);
            max = Math.max(max, minTime[next]);
        }
        minTime[start] = max + time[start - 1];
    }
}
