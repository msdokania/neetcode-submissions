class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n=grid.length, m=grid[0].length;
        int INF = Integer.MAX_VALUE;
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j]==0) q.offer(new int[]{i,j});
            }
        }
        int steps = 0;
        while(!q.isEmpty()) {
            int siz = q.size();
            while(siz>0) {
                int[] tmp = q.poll();
                for(int[] d : dir) {
                    int nr = tmp[0]+d[0];
                    int nc = tmp[1]+d[1];
                    if(nr<n && nr>=0 && nc<m && nc>=0 && grid[nr][nc]==INF) {
                        grid[nr][nc] = 1+steps;
                        q.offer(new int[]{nr,nc});
                    }
                }
                siz--;
            }
            steps++;
        }
    }
}
