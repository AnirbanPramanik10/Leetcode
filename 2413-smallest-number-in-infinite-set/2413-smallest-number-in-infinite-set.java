class SmallestInfiniteSet {
    PriorityQueue<Integer> set;
    public SmallestInfiniteSet() {
        set = new PriorityQueue<>();
        for(int i = 1 ; i <= 1000 ; i++) {
            set.offer(i);
        }
    }
    
    public int popSmallest() {
        return set.poll();
    }
    
    public void addBack(int num) {
        if (!set.contains(num)) set.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */