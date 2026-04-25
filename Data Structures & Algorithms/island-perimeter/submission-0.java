class Solution {
    int ans = 0;
    int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
    public int islandPerimeter(int[][] grid) {
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]==1) {
                    helper(grid, i,j);
                }
            }
        }
        return ans;
    }
    public void helper(int[][] grid, int r, int c) {
        if(r==0) ans++;
        if(c==0) ans++;
        if(r==grid.length-1) ans++;
        if(c==grid[0].length-1) ans++;
        grid[r][c] = -1;
        for(int d=0; d<4; d++) {
            int nr = r+dir[d][0];
            int nc = c+dir[d][1];
            if(nr>=grid.length || nc>=grid[0].length || nr<0 || nc<0)
                continue;
            if(grid[nr][nc]==0)
                ans++;
            else if(grid[nr][nc]==1) {
                helper(grid, nr,nc);
            }
        }
    }
}