class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->(a[0]-b[0]));
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(intervals[0]);
        for(int i=1; i<intervals.length; i++) {
            while(!dq.isEmpty() && dq.peekLast()[1]>=intervals[i][0]) {
                int[] tmp = dq.pollLast();
                intervals[i][0] = Math.min(intervals[i][0],tmp[0]);
                intervals[i][1] = Math.max(intervals[i][1],tmp[1]);
            }
            dq.offer(intervals[i]);
        }
        return dq.toArray(new int[dq.size()][2]);
    }
}
