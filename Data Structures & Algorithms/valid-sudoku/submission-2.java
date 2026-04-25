class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] grid = new int[9];
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                int x = (i/3)*3 + (j/3);
                if(board[i][j]=='.') continue;
                int tmp = (board[i][j]-'1');
                if((rows[i] & (1<<tmp)) != 0) return false;
                if((cols[j] & (1<<tmp)) != 0) return false;
                if((grid[x] & (1<<tmp)) != 0) return false;
                rows[i] |= (1<<tmp);
                cols[j] |= (1<<tmp);
                grid[x] |= (1<<tmp);
            }
        }
        return true;
    }
}


