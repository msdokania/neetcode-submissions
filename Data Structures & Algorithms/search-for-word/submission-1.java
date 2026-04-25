class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j]==word.charAt(0)) {
                    boolean x = helper(board, word, 0, i, j, new boolean[n][m]);
                    if(x) return true;
                }
            }
        }
        return false;
    }
    public boolean helper(char[][] board, String word, int idx, int i, int j, boolean[][] visited) {
        if(idx==word.length())
            return true;
        if(i>=board.length || i<0 || j<0 || j>=board[0].length)
            return false;
        if(word.charAt(idx)!=board[i][j] || visited[i][j])
            return false;
        visited[i][j] = true;
        boolean x = helper(board, word, idx+1, i, j+1, visited) || 
                    helper(board, word, idx+1, i+1, j, visited) || 
                    helper(board, word, idx+1, i, j-1, visited) || 
                    helper(board, word, idx+1, i-1, j, visited);
        visited[i][j] = false;
        return x;
    }
}
