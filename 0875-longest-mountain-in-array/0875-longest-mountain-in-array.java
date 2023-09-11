class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int max = 0;
        for (int i = 1;i<n-1;) {
            if (arr[i-1]<arr[i] && arr[i]>arr[i+1]) {
                int count = 1 , j = i-1;
                while(j>=0 && arr[j]<arr[j+1]) {
                    count++;
                    j--;
                }
                while(i+1<n && arr[i+1]<arr[i]) {
                    i++;
                    count++;
                }
                max = Math.max(max, count);
            }
            else i++;
        }
        return max<3?0:max;
    }
}