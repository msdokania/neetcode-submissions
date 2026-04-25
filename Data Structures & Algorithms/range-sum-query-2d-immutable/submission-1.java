class NumMatrix {
    int[][] prefix;

    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        prefix = new int[n+1][m+1];
        for(int i=1; i<=n; i++) {
            int currsum = 0;
            for(int j=1; j<=m; j++) {
                currsum += matrix[i-1][j-1];
                prefix[i][j] = currsum + prefix[i-1][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = 0;
        int bottomRight = prefix[row2+1][col2+1];
        int above = prefix[row1][col2+1];
        int left = prefix[row2+1][col1];
        int topLeft = prefix[row1][col1];
        ans = bottomRight - above - left + topLeft;
        // for(int i=row1; i<=row2; i++) {
        //     int x = (prefix[i][col2+1] - prefix[i][col1]);
        //     ans += x;
        // }
        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */