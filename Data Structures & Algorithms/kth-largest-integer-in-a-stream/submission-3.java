class KthLargest {
    Queue<Integer> q;
    int k;

    public KthLargest(int k, int[] nums) {
        q = new PriorityQueue<>();
        this.k = k;
        for(int x : nums) {
            q.offer(x);
            if(q.size()>k)
                q.poll();
        }
    }
    
    public int add(int val) {
        q.offer(val);
        if(q.size()>k)
            q.poll();
        return q.peek();
    }
}
