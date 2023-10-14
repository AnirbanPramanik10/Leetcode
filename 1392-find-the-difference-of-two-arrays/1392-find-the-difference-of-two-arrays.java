public class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            set2.add(num);
        }

        List<Integer> difference1 = new ArrayList<>();
        List<Integer> difference2 = new ArrayList();

        for (int num : set1) {
            if (!set2.contains(num)) {
                difference1.add(num);
            }
        }

        for (int num : set2) {
            if (!set1.contains(num)) {
                difference2.add(num);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(difference1);
        result.add(difference2);

        return result;
    }
}
