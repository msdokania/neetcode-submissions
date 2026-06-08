class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        Queue<int[]> alltasks = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        Queue<int[]> available = new PriorityQueue<>((a,b)->(a[0]!=b[0]? a[0]-b[0] : a[1]-b[1]));
        for(int i=0; i<n; i++)
            alltasks.offer(new int[]{tasks[i][0],tasks[i][1],i});
        int currtime = alltasks.peek()[0];
        int[] ans = new int[n];
        int idx = 0;
        while(!alltasks.isEmpty() || !available.isEmpty()) {
            while(!alltasks.isEmpty() && alltasks.peek()[0]<=currtime) {
                int[] x = alltasks.poll();
                available.offer(new int[]{x[1],x[2]});
            }
            if(!available.isEmpty()) {
                int[] x = available.poll();
                ans[idx++] = x[1];
                currtime += x[0];
            } else {
                currtime = alltasks.peek()[0];
            }
        }
        return ans;
    }
}