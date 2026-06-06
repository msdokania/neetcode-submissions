class Solution {
    int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
    public boolean exist(char[][] board, String word) {
        int n=board.length, m=board[0].length;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j]!=word.charAt(0)) continue;
                boolean ret = helper(board, word, i,j,n,m,0);
                if(ret) return true;
            }
        }
        return false;
    }
    public boolean helper(char[][] board, String word, int i, int j, int n, int m, int idx) {
        if(idx==word.length()) {
            return true;
        }
        if(i>=n||j>=m||i<0||j<0 || idx>word.length()) return false;
        if(board[i][j]=='#' || board[i][j]!=word.charAt(idx))
            return false;
        board[i][j] = '#';
        
        boolean x = helper(board, word, i+1, j, n,m, idx+1) || helper(board, word, i-1, j, n,m, idx+1)
                    || helper(board, word, i, j+1, n,m, idx+1) || helper(board, word, i, j-1, n,m, idx+1);
        if(x) return true;
        board[i][j] = word.charAt(idx);
        return false;
    }
}
