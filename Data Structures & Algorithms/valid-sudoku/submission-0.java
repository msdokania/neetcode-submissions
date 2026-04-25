class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] R = new int[9];
        int[] C = new int[9];
        int[] G = new int[9];
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(board[i][j]=='.') continue;
                int gridIdx = (i/3)*3 + (j/3);
                int pos = 1 << Character.getNumericValue(board[i][j]);
                if((R[i] & pos) !=0 || (C[j] & pos) !=0 || (G[gridIdx] & pos) !=0)
                    return false;
                R[i] |= pos;
                C[j] |= pos;
                G[gridIdx] |= pos;
            }
        }
        return true;
    }
}
