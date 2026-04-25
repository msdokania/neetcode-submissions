class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Queue<Integer> available = new PriorityQueue<>();
        int[] ans = new int[n];
        Arrays.sort(meetings, (a,b)->(a[0]-b[0]));
        Queue<long[]> meet = new PriorityQueue<>((a,b)->(a[1]!=b[1]? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0])));
        for(int i=0; i<n; i++)
            available.offer(i);
        for(int i=0; i<meetings.length; i++) {
            int start=meetings[i][0], end = meetings[i][1];
            while(!meet.isEmpty() && meet.peek()[1]<=start) {
                available.offer((int)meet.poll()[0]);
            }
            int currendtime = end;
            if(available.isEmpty()) {
                long[] over = meet.poll();
                end = (int)over[1]+(end-start);
                available.offer((int)over[0]);
            }
            int room = available.poll();
            ans[room]++;
            meet.offer(new long[]{room, end});
        }
        int maxroom = -1;
        int max = 0;
        for(int i=n-1; i>=0; i--) {
            if(max<=ans[i]) {
                max = ans[i];
                maxroom = i;
            }
        }
        return maxroom;
    }
}