class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] sq = new HashSet[9];
        for(int i=0; i<9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            sq[i] = new HashSet<>();
        }
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(board[i][j] == '.')
                    continue;
                char c = board[i][j];
                if(rows[i].contains(c)) return false;
                rows[i].add(c);
                if(cols[j].contains(c)) return false;
                cols[j].add(c);
                int tmp = (i/3)*3 + j/3;
                if(sq[tmp].contains(c)) return false;
                sq[tmp].add(c);
            }
        }
        return true;
    }
}
