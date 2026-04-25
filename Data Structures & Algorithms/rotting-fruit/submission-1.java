class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int n=grid.length, m=grid[0].length;
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
        int ans = 0;
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        while(!q.isEmpty()) {
            int len = q.size();
            while(len>0) {
                int[] curr = q.poll();
                len--;
                for(int d=0; d<4; d++) {
                    int nr = curr[0]+dir[d][0];
                    int nc = curr[1]+dir[d][1];
                    if(nr>=n || nr<0 || nc>=m || nc<0 || grid[nr][nc]!=1)
                        continue;
                    grid[nr][nc] = 2;
                    fresh--;
                    q.offer(new int[]{nr,nc});
                }
            }
            ans++;
        }
        return fresh==0? ans-1 : -1;
    }
}
