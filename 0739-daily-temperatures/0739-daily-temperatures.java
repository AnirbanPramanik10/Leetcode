class Solution {
    public int[] dailyTemperatures(int[] arr) {
        int[] ans = new int[arr.length];
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i=0; i<arr.length; i++){
            int n = arr[i];
            while(!deque.isEmpty() && arr[deque.peek()] < n){
                int j = deque.pop();
                ans[j] = i - j;
            }
            deque.push(i);
        }
        return ans;
    }
}