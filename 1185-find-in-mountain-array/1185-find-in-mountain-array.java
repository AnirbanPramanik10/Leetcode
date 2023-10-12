/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
 class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = findPeakElement(mountainArr);
        int result = binarySearch(mountainArr, target, 0, peak, true);
        return result != -1 ? result : binarySearch(mountainArr, target, peak + 1, mountainArr.length() - 1, false);
    }

    static int findPeakElement(MountainArray nums) {
        int start = 0, end = nums.length() - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums.get(mid) > nums.get(mid + 1)) end = mid;
            else start = mid + 1;
        }
        return start;
    }

    static int binarySearch(MountainArray arr, int target, int start, int end, boolean isAscending) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midValue = arr.get(mid);

            if (midValue == target) return mid;
            if ((isAscending && midValue < target) || (!isAscending && midValue > target)) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
}
