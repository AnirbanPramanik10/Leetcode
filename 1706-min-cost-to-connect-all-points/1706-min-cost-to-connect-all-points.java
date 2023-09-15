class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[] {i, j, dist});
            }
        }
        // Sort by weight
        Collections.sort(edges, (a, b) ->Integer.compare(a[2], b[2]));
        // Use DSU to get parent
        int[] parents = new int[points.length];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        // Add edges that aren't creating a loop
        int mstTotal = 0;
        int edgeUsed = 0;
        for (int[] edge : edges) {
            int i = edge[0];
            int j = edge[1];
            int parentI = findParent(parents, i);
            int parentJ = findParent(parents, j);
            if (parentI != parentJ) {
                // Union
                parents[parentI] = parentJ;
                mstTotal += edge[2];
                edgeUsed++;
                if (edgeUsed == points.length - 1) {
                    break;
                }
            }
        }
        return mstTotal;
    }
    
    int findParent(int[] parents, int i) {
        if (parents[i] == i) {
            return i;
        }
        int parent = findParent(parents, parents[i]);
        parents[i] = parent;
        return parent;
    }
}