class MyStack {
    final LinkedList<Integer> nums;

    public MyStack() {
        nums = new LinkedList<>();
    }

    public void push(int x) {
        nums.push(x);
    }

    public int pop() {
        return nums.pop();
    }

    public int top() {
        return nums.getFirst();
    }

    public boolean empty() {
        return nums.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */