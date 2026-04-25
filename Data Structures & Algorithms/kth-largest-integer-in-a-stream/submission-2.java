class KthLargest {
    Queue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.k = k;
        for(int num : nums) {
            insert(num);
        }
    } 
    
    public int add(int val) {
        insert(val);
        return pq.peek();
    }
    public void insert(int val) {
        pq.offer(val);
        if(pq.size() > k) {
            pq.poll();
        }
    }
}


