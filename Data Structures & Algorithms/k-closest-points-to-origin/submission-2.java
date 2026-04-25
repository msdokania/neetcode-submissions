class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        int m = points[0].length;
        Queue<int[]> pq = new PriorityQueue<>((a,b)-> (Integer.compare((b[0]*b[0] + b[1]*b[1]),(a[0]*a[0] + a[1]*a[1]))));
        for(int[] p : points) {
            pq.offer(p);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        int[][] ans = new int[k][2];
        int idx = 0;
        while(!pq.isEmpty()) {
            ans[idx++] = pq.poll();
        }
        return ans;
    }
}
