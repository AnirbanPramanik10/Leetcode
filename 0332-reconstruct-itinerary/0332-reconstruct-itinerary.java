class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> ans = new LinkedList<>();
        HashMap<String, PriorityQueue<String>> adj = new HashMap<>();

        for (List<String> ticket : tickets) {
            adj.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }

        dfs("JFK", adj, ans);
        return ans;
    }

    private void dfs(String src, HashMap<String, PriorityQueue<String>> adj, LinkedList<String> ans) {
        PriorityQueue<String> destinations = adj.get(src);

        while (destinations != null && !destinations.isEmpty()) {
            dfs(destinations.poll(), adj, ans);
        }

        ans.addFirst(src);
    }
}
