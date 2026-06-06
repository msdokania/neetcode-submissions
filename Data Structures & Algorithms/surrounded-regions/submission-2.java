class Solution {
    int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
    public void solve(char[][] board) {
        int n=board.length, m=board[0].length;
        for(int i=0; i<n; i++) {
            if(board[i][0]=='O') bfs(board, i,0,n,m);
            if(board[i][m-1]=='O') bfs(board, i,m-1,n,m);
        }
        for(int j=0; j<m; j++) {
            if(board[0][j]=='O') bfs(board, 0,j,n,m);
            if(board[n-1][j]=='O') bfs(board, n-1,j,n,m);
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j]=='.') board[i][j] = 'O';
                else if(board[i][j]=='O') board[i][j] = 'X';
            }
        }
    }
    public void bfs(char[][] board, int r, int c, int n, int m) {
        board[r][c] = '.';
        for(int[] d : dir) {
            int nr = r+d[0];
            int nc = c+d[1];
            if(nr>=n||nc>=m||nr<0||nc<0 || board[nr][nc]!='O')
                continue;
            bfs(board, nr, nc,n,m);
        }
    }
}
