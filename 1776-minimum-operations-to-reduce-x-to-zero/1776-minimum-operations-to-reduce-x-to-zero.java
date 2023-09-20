class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int target = -x;
        if (target == 0) return 0;
        for (int num : nums) target += num;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0, res = -1;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            map.put(sum, i);
            
            if (map.containsKey(sum - target)) {
                res = Math.max(res, i - map.get(sum - target));
            }
        }

        return res == -1 ? res : n - res;
    }
}