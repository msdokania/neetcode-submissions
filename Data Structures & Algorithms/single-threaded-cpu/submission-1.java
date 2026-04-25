class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[] ans = new int[n];
        int[][] tasksOrder = new int[n][3];
        for(int i=0; i<n; i++) 
            tasksOrder[i] = new int[]{tasks[i][0],tasks[i][1],i};
        Arrays.sort(tasksOrder, (a,b)->(a[0]!=b[0]? a[0]-b[0] : a[2]-b[2]));
        Queue<int[]> pq = new PriorityQueue<>((a,b)->(a[1]!=b[1]? a[1]-b[1] : a[2]-b[2]));
        int time = tasksOrder[0][0];
        int i=0;
        int idx = 0;
        while(i<n || !pq.isEmpty()) {
            while(i<n && time>=tasksOrder[i][0]) {
                pq.offer(tasksOrder[i]);
                i++;
            }
            if(pq.isEmpty()) {
                time = tasksOrder[i][0];
                continue;
            }
            int[] tmp = pq.poll();
            time += tmp[1];
            ans[idx++] = tmp[2];
        }
        return ans;
    }
}