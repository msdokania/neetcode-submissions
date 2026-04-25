class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    ans++;
                    travel(grid,i,j);
                }
            }
        }
        return ans;
    }
    public void travel(char[][] grid, int r, int c) {
        if(r>=grid.length||r<0||c>=grid[0].length||c<0 || grid[r][c]=='0')
            return;
        grid[r][c] = '0';
        travel(grid, r+1,c);
        travel(grid, r-1,c);
        travel(grid, r,c+1);
        travel(grid, r,c-1);
    }
}
