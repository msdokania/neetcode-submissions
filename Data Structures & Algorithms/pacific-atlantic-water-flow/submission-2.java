class Solution {
    int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n=heights.length, m=heights[0].length;
        int[][] pacific = new int[n][m];
        int[][] atlantic = new int[n][m];
        for(int i=0; i<n; i++) {
            dfs(heights, i, 0, pacific);
            dfs(heights, i, m-1, atlantic);
        }
        for(int j=0; j<m; j++) {
            dfs(heights, 0, j, pacific);
            dfs(heights, n-1, j, atlantic);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(pacific[i][j]==1 && atlantic[i][j]==1)
                    ans.add(Arrays.asList(i,j));
            }
        }
        return ans;
    }
    public void dfs(int[][] heights, int r, int c, int[][] arr) {
        arr[r][c] = 1;
        for(int d=0; d<4; d++) {
            int nr=r+dir[d][0];
            int nc=c+dir[d][1];
            if(nr>=heights.length||nr<0||nc>=heights[0].length||nc<0 || arr[nr][nc]==1 || heights[nr][nc]<heights[r][c])
                continue;
            dfs(heights, nr, nc, arr);
        }
    }
}





