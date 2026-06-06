class Solution {
    int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
    public void islandsAndTreasure(int[][] grid) {
        int n=grid.length, m=grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j]==0)
                    q.offer(new int[]{i,j});
            }
        }
        int level = 1;
        boolean[][] vis = new boolean[n][m];
        while(!q.isEmpty()) {
            int len = q.size();
            while(len>0) {
                int[] curr = q.poll();
                for(int[] d : dir) {
                    int nr = curr[0]+d[0];
                    int nc = curr[1]+d[1];
                    if(nr>=n||nc>=m||nr<0||nc<0 || grid[nr][nc]==-1 || vis[nr][nc])
                        continue;
                    grid[nr][nc] = Math.min(grid[nr][nc], level);
                    q.offer(new int[]{nr,nc});
                    vis[nr][nc] = true;
                }
                len--;
            }
            level++;
        }
    }
}
