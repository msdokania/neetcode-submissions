class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Queue<int[]> pending = new PriorityQueue<>((a,b)->(a[1]-b[1]));
        Queue<int[]> available = new PriorityQueue<>((a,b)->(a[2]-b[2]));
        for(int[] x : trips)
            pending.offer(x);
        while(!pending.isEmpty()) {
            int[] x = pending.poll();
            while(!available.isEmpty() && x[1]>=available.peek()[2]) {
                int[] tmp = available.poll();
                capacity += tmp[0];
            }
            if(capacity<x[0]) return false;
            capacity -= x[0];
            available.offer(x);
        }
        return true;
    }
}

// , 
// x = [3,2,4]
// cap = 4

