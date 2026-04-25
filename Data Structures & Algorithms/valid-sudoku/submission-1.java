class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] grid = new HashSet[9];
        for(int i=0; i<9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            grid[i] = new HashSet<>();
        }
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                char c = board[i][j];
                int x = (i/3)*3 + (j/3);
                if(c=='.') continue;
                if(rows[i].contains(c)) return false;
                if(cols[j].contains(c)) return false;
                if(grid[x].contains(c)) return false;
                rows[i].add(c);
                cols[j].add(c);
                grid[x].add(c);
            }
        }
        return true;
    }
}


