class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        if(n<2) return 0;
        int ans = 0, finalstate = (1<<n)-1;
        boolean vis[][] = new boolean[n][finalstate+1];
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i<n; i++)
        {
            q.add(new int[]{i, 1<<i});
        }

        while(!q.isEmpty())
        {
            int size = q.size();
            ans++;
            while(size-- > 0)
            {
                int node[] = q.remove();
                for(int i = 0; i<graph[node[0]].length; i++)
                {
                    int neighbor = graph[node[0]][i];
                    int newmask = node[1] | (1<<neighbor);
                    if(vis[neighbor][newmask])
                        continue;
                    if(newmask == finalstate) return ans;    
                    vis[neighbor][newmask] = true;
                    q.add(new int[]{neighbor, newmask});    
                }
            }
        }
        return ans;
    }
}