class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
        for(int x : stones)
            pq.offer(x);
        while(!pq.isEmpty() && pq.size()!=1) {
            int a = pq.poll();
            int b = pq.poll();
            int diff = Math.abs(a-b);
            if(diff>0) pq.offer(diff);
        }
        if(!pq.isEmpty()) return pq.peek();
        return 0;
    }
}
