class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < n; i++){
            graph.put(i, new ArrayList<>());
        }

        for(int road[] : roads){
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }

        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                maxi = Math.max(maxi, findNetworkRank(i, j, graph));
            }
        }
        return maxi;
    }

    public int findNetworkRank(int i, int j, Map<Integer, List<Integer>> graph){
        int cnt = 0;
        boolean isConnected = false;
        for(int node : graph.get(i)){
            if(node == j){
                isConnected = true;
            }
            cnt++;
        }

        for(int node : graph.get(j)){
            cnt++;
        }
        return isConnected == true ? cnt - 1 : cnt;
    }
}