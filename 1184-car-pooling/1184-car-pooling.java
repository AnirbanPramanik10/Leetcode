class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] arr = new int[1010];
        updateStops(arr, trips);
        return isCarpoolPossible(arr, capacity);
    }
    
    private void updateStops(int[] arr, int[][] trips) {
        for (int[] nums : trips) {
            arr[nums[1]] += nums[0];
            arr[nums[2]] -= nums[0];
        }
    }
    
    private boolean isCarpoolPossible(int[] arr, int cp) {
        for (int i : arr) {
            cp -= i;
            if (cp < 0) return false;
        }
        return true;
    }
}
