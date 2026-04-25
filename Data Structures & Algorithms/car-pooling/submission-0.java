class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;
        Queue<int[]> pq = new PriorityQueue<>((a,b)->(a[1]-b[1]));
        Queue<int[]> drops = new PriorityQueue<>((a,b)->(a[2]-b[2]));
        int currcap = 0;
        // int currdist = 0;
        for(int[] x : trips)
            pq.offer(x);
        while(!pq.isEmpty()) {
            int[] tmp = pq.poll();
            while(!drops.isEmpty() && drops.peek()[2]<=tmp[1]) {
                currcap -= drops.peek()[0];
                drops.poll();
            }
            currcap += tmp[0];
            // currdist = Math.max(currdist, tmp[2]);
            if(currcap > capacity)
                return false;
            // currdist = Math.max(currdist, tmp[1]);
            drops.offer(tmp);
        }
        return true;
    }
}