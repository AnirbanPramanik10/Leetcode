class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int res[] = new int[temperatures.length];
        for(int i = temperatures.length-1 ; i >= 0; i--){
            while(stack.isEmpty()==false && temperatures[i]>=temperatures[stack.peek()]) stack.pop();
            if(stack.isEmpty()) res[i] = 0;
            else res[i] = stack.peek() - i;
            stack.push(i);  
        }
        return res;
    }
}