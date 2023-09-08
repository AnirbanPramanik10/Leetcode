class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;

        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        Queue<Integer> q = new LinkedList<>();
        q.add(entrance[0]);
        q.add(entrance[1]);
        q.add(0);

        boolean visited[][] = new boolean[n][m];
        

        while(!q.isEmpty()) {

            int cx = q.poll();
            int cy = q.poll();
            int dist = q.poll();
            // System.out.println(cx + " " + cy);
            visited[cx][cy] = true;

            if (!(cx == entrance[0] && cy == entrance[1])) {

                if(cx == 0 || cx == n-1 || cy == 0|| cy == m-1)
                   return dist;
            }
            for(int i=0;i<4;i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || nx >=n || ny <0 || ny >=m) continue;

                if (maze[nx][ny] == '+') continue;

                if (!visited[nx][ny]) {
                    q.add(nx);
                    q.add(ny);
                    q.add(dist+1);
                    visited[nx][ny] = true;
                }
            }
        }
        return -1;
    }
}