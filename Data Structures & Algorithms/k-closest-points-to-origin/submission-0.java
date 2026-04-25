class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<Pair<Double,Integer>> pq = new PriorityQueue<>((a,b)->(Double.compare(b.getKey(),a.getKey())));
        for(int i=0; i<points.length; i++) {
            int[] point = points[i];
            double dist = Math.sqrt(point[0]*point[0] + point[1]*point[1]);
            pq.offer(new Pair<Double,Integer>(dist,i));
            if(pq.size()>k) pq.poll();
        }
        int[][] ans = new int[k][2];
        int idx = 0;
        while(!pq.isEmpty()) {
            Pair<Double,Integer> p = pq.poll();
            ans[idx] = points[p.getValue()];
            idx++;
        }
        return ans;
    }
}
