class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length, m=grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j]==2) 
                    q.offer(new int[]{i,j});
                else if(grid[i][j]==1)
                    fresh++;
            }
        }
        if(fresh==0) return 0;
        int time = 0;
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        while(!q.isEmpty()) {
            int len = q.size();
            while(len>0) {
                int[] cell = q.poll();
                for(int[] d : dir) {
                    int nr = cell[0]+d[0];
                    int nc = cell[1]+d[1];
                    if(nr<n && nc<m && nr>=0 && nc>=0 && grid[nr][nc]==1) {
                        grid[nr][nc] = 2;
                        q.offer(new int[]{nr,nc});
                        fresh--;
                    }
                }
                len--;
            }
            time++;
            if(fresh==0) return time;
        }
        return fresh==0? time : -1;
    }
}
