class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Queue<Integer> available = new PriorityQueue<>();
        int[] ans = new int[n];
        Arrays.sort(meetings, (a,b)->(a[0]-b[0]));
        Queue<int[]> meet = new PriorityQueue<>((a,b)->(a[1]!=b[1]? a[1]-b[1] : a[0]-b[0]));
        for(int i=0; i<n; i++)
            available.offer(i);
        for(int i=0; i<meetings.length; i++) {
            int start=meetings[i][0], end = meetings[i][1];
            while(!meet.isEmpty() && meet.peek()[1]<=start) {
                available.offer(meet.poll()[0]);
            }
            int currendtime = end;
            if(available.isEmpty()) {
                int[] over = meet.poll();
                end = over[1]+(end-start);
                available.offer(over[0]);
            }
            int room = available.poll();
            ans[room]++;
            meet.offer(new int[]{room, end});
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