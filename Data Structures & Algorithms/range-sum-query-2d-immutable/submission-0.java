class NumMatrix {
    int[][] prefix;

    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        prefix = new int[n][m+1];
        for(int i=0; i<n; i++) {
            int currsum = 0;
            for(int j=0; j<=m; j++) {
                prefix[i][j] = currsum;
                if(j!=m)
                    currsum += matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = 0;
        for(int i=row1; i<=row2; i++) {
            int x = (prefix[i][col2+1] - prefix[i][col1]);
            ans += x;
        }
        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */