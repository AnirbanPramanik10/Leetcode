class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> edges = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int n = points.length;
        Set<Integer> visited = new HashSet<>();
        int i = 0;
        for (int j = 1; j < n; j++) {
            edges.add(new int[]{0, j, dist(points[0], points[j])});
        }
        int edgeCount = 0;
        visited.add(0);
        int res = 0;
        while (!edges.isEmpty() && edgeCount < n) {
            int[] curr = edges.poll();
            int p1 = curr[0], p2 = curr[1], weight = curr[2];
            if (!visited.contains(p2)) {
                visited.add(p2);
                edgeCount++;
                if (edgeCount >= n) break;
                res += weight;
                for (int j = 0; j < n; j++) {
                    if (!visited.contains(j))
                        edges.add(new int[] {p2, j, dist(points[p2], points[j])});
                }
            }
        }
        return res;
    }

    private int dist(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}