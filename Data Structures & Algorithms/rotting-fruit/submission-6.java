class Solution {
    int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
    public int orangesRotting(int[][] grid) {
        int n=grid.length, m=grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j]==1) fresh++;
                if(grid[i][j]==2)
                    q.offer(new int[]{i,j});
            }
        }
        int time = 1;
        if(fresh==0) return 0;
        while(!q.isEmpty()) {
            int len = q.size();
            while(len>0) {
                int[] curr = q.poll();
                for(int[] d : dir) {
                    int nr = curr[0]+d[0];
                    int nc = curr[1]+d[1];
                    if(nr>=n||nc>=m||nr<0||nc<0 || grid[nr][nc]!=1)
                        continue;
                    grid[nr][nc] = 2;
                    q.offer(new int[]{nr,nc});
                    fresh--;
                    if(fresh==0) return time;
                }
                len--;
            }
            time++;
        }
        return -1;
    }
}
