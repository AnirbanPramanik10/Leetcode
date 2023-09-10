class Solution {
        public int minReorder(int n, int[][] arr) {
        boolean[] visited = new boolean[n];
        visited[0] = true;
        LinkedList<int[]> q = new LinkedList<>();
        int count = 0;
        
        for (int[] a : arr) {
            if (visited[a[0]]) {
                ++count;
                visited[a[1]] = true;
            } else {
                if (visited[a[1]]) visited[a[0]] = true;
                else q.add(a);
            }
        }
        while (!q.isEmpty()) {
            int[] a = q.pollLast();
            if (visited[a[0]]) {
                ++count;
                visited[a[1]] = true;
            } else {
                if (visited[a[1]]) visited[a[0]] = true;
                else q.addFirst(a);
            }
        }
        return count;
    }
}