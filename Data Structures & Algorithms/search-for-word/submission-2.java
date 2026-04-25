class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    boolean x = helper(board, i,j, word, 0);
                    if(x)
                        return true;
                }
            }
        }
        return false;
    }
    public boolean helper(char[][] board, int i, int j, String word, int idx) {
        if(idx==word.length())
            return true;
        if(i>=board.length || j>=board[0].length || i<0 || j<0 || board[i][j]=='.' || board[i][j]!=word.charAt(idx))
            return false;
        char c = board[i][j];
        board[i][j] = '.';
        boolean x = helper(board, i+1,j, word, idx+1) ||
                    helper(board, i-1,j, word, idx+1) ||
                    helper(board, i,j+1, word, idx+1) ||
                    helper(board, i,j-1, word, idx+1);
        board[i][j] = c;
        return x;
    }
}
