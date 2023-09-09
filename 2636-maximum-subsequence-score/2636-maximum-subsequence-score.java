class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] pair = new int[n][2];

        for (int i = 0; i < n; i++) {
            pair[i][0] = nums2[i];
            pair[i][1] = nums1[i];
        }

        Arrays.sort(pair, (a, b) -> b[0] - a[0]);

        long ans = 0, curr_sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            curr_sum += pair[i][1];
            pq.add(pair[i][1]);

            if (i >= k) curr_sum -= pq.poll();

            if (i >= k - 1) ans = Math.max(ans, curr_sum * pair[i][0]);
        }
        return ans;
    }
}
