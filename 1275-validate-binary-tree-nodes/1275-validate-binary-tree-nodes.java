class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] parent = new int[n];
        int[] indegree = new int[n];
        for (int i = 0; i < parent.length; i++) parent[i] = i;

        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1 ) {
                if (union(i, leftChild[i], parent) == false) return false;
                indegree[leftChild[i]]++;
            }
            if (rightChild[i] != -1 ) {
                if (union(i, rightChild[i], parent) == false) return false;
                indegree[rightChild[i]]++;
            }
        }

        int groupCnt = 0;
        int rootCnt = 0;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) rootCnt++;
            if (i == find(i, parent)) groupCnt++;
            if (rootCnt > 1) return false;
            if (groupCnt > 1) return false;
        }

        return true;
    }

    private int find(int i, int[] parent) {
        if (i != parent[i]) return find(parent[i], parent);
        else return i;
    }

    private boolean union(int i1, int i2, int[] parent) {
        int p1 = find(i1, parent);
        int p2 = find(i2, parent);
        if (p1 == p2) {
            return false;
        }else {
            if (p1 < p2) parent[p2] = p1;
            else parent[p1] = p2;
            return true;
        }
    }
}

