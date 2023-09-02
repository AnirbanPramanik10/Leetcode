class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> output = new ArrayList<>();
        PriorityQueue<int[]> sumQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < nums1.length; i++) {
            sumQueue.offer(new int[] { nums1[i] + nums2[0], 0 });
        }
        // System.out.println(sumQueue + "\n");

        while (k-- > 0 && !sumQueue.isEmpty()) {
            int[] curr = sumQueue.poll();
            int sum = curr[0];
            int num2Idx = curr[1];
            output.add(List.of(sum - nums2[num2Idx], nums2[num2Idx]));

            if (num2Idx + 1 < nums2.length) {
                sumQueue.offer(new int[] { sum - nums2[num2Idx] + nums2[num2Idx + 1], num2Idx + 1 });
            }
        }
        // System.out.println(output + "\n");
        return output;
    }
}