class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n=grid.length, m=grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 0)
                    q.offer(new int[]{i,j});
            }
        }
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        int INF = Integer.MAX_VALUE;
        while(!q.isEmpty()) {
            int len = q.size();
            while(len>0) {
                int[] x = q.poll();
                for(int[] d : dir) {
                    int nr = x[0]+d[0];
                    int nc = x[1]+d[1];
                    if(nr>=n||nc>=m||nr<0||nc<0 || grid[nr][nc]!=INF)
                        continue;
                    grid[nr][nc] = grid[x[0]][x[1]] + 1;
                    q.offer(new int[]{nr,nc});
                }
                len--;
            }
        }
    }
}
