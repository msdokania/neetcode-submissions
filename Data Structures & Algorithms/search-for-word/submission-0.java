class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                    boolean x = helper(0, i,j, board, word, new boolean[n][m]);
                    if(x) return true;
            }
        }
        return false;
    }
    public boolean helper(int curLen,int r, int c, char[][] board, String word, boolean[][] vis) {
        if(curLen==word.length()) {
            return true;
        }
        if(r>=board.length || c>=board[0].length || r<0 || c<0 || vis[r][c] || board[r][c]!=word.charAt(curLen))
            return false;
        vis[r][c] = true;
        boolean x = helper(curLen+1,r+1,c,board,word,vis) || helper(curLen+1,r,c+1,board,word,vis) || helper(curLen+1,r-1,c,board,word,vis) || helper(curLen+1,r,c-1,board,word,vis);
        vis[r][c] = false;
        return x;
    }
}
