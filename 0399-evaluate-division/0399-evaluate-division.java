class Solution {
    class Node {
        String key;
        double val;
        public Node(String key, double val) {
            this.key = key;
            this.val = val;
        }
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Node>> map = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            String src = equations.get(i).get(0), des = equations.get(i).get(1);
            map.putIfAbsent(src, new ArrayList<>());
            map.putIfAbsent(des, new ArrayList<>());
            map.get(src).add(new Node(des, values[i]));
            map.get(des).add(new Node(src, 1 / values[i]));
        }
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            result[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), map, new HashSet<>());
        }
        return result;
    }

    double dfs(String src, String des, Map<String, List<Node>> graph, Set<String> vis) {
        if (!graph.containsKey(src) || !graph.containsKey(des)) return -1.0;
        if (src.equals(des)) return 1.0;
        vis.add(src);
        for (Node n : graph.get(src)) {
            if (!vis.contains(n.key)) {
                double ans = dfs(n.key, des, graph, vis);
                if (ans != -1.0) return ans * n.val;
            }
        }
        return -1.0;
    }
}
