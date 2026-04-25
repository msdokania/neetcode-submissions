class Solution {
    int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
    public void solve(char[][] board) {
        int n = board.length, m=board[0].length;
        for(int i=0; i<n; i++) {
            if(board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if(board[i][m-1] == 'O') {
                dfs(board, i, m-1);
            }
        }
        for(int j=0; j<m; j++) {
            if(board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if(board[n-1][j] == 'O') {
                dfs(board, n-1, j);
            }
        }
        for(int i=1; i<n-1; i++) {
            for(int j=1; j<m-1; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j] == '.') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    public void dfs(char[][] board, int r, int c) {
        board[r][c] = '.';
        for(int[] d : dir) {
            int nr=r+d[0];
            int nc=c+d[1];
            if(nr>=board.length||nr<0||nc>=board[0].length||nc<0 || board[nr][nc]!='O')
                continue;
            dfs(board, nr,nc);
        }
    }

}
