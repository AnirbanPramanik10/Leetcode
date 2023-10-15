class Solution {
    public static long totalCost(int[] costs, int k, int candidates)  {
        int n = costs.length;
        long total = 0;
        if ((n - (2 * candidates)) < k || n == k) {
            Arrays.sort(costs);
            for (int i = 0; i < k; i++) {
                total += costs[i];
            }
            return total;
        }
        int lo = 0;
        int hi = n - 1;
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        for (int i = 0; i < candidates; i++) {
            pq1.add(costs[lo++]);
            pq2.add(costs[hi--]);
        }
        while (k-- > 0) {
            if (pq1.peek() <= pq2.peek()) {
                total += pq1.poll();
                pq1.offer(costs[lo++]);
            }
            else {
                total += pq2.poll();
                pq2.offer(costs[hi--]);
            }
        }
        return total;
    }  
}