class Solution {
    int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n=heights.length, m=heights[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        boolean[][] p = new boolean[n][m];
        boolean[][] a = new boolean[n][m];
        for(int i=0; i<n; i++) {
            dfs(heights, i,0,n,m,p);
            dfs(heights, i,m-1,n,m,a);
        }
        for(int j=0; j<m; j++) {
            dfs(heights, 0,j,n,m,p);
            dfs(heights, n-1,j,n,m,a);
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(p[i][j] && a[i][j]) 
                    ans.add(Arrays.asList(i,j));
            }
        }
        return ans;
    }
    public void dfs(int[][] heights, int r, int c, int n, int m, boolean[][] res) {
        res[r][c] = true;
        for(int[] d : dir) {
            int nr = r+d[0];
            int nc = c+d[1];
            if(nr>=n||nc>=m||nr<0||nc<0 || heights[nr][nc]<heights[r][c] || res[nr][nc])
                continue;
            dfs(heights,nr,nc,n,m,res);
        }
    }
}






