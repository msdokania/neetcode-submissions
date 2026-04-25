class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int l=0, r=n-1, idx = 0;
        while(l<=r) {
            idx = (l+r)/2;
            if(target == matrix[idx][0] || target == matrix[idx][m-1])
                return true;
            else if(target > matrix[idx][0] && target < matrix[idx][m-1])
                break;
            else if(target < matrix[idx][0])
                r = idx-1;
            else
                l = idx+1;
        }
        l=0;
        r=m-1;
        while(l<=r) {
            int mid = (l+r)/2;
            if(target == matrix[idx][mid])
                return true;
            else if(target < matrix[idx][mid])
                r = mid-1;
            else
                l = mid+1;
        }
        return false;
    }
}
