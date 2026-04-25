class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        int score = helper(piles, 0, n-1, dp);
        int total = 0;
        for(int x : piles) total += x;
        return score>total/2? true : false;
    }
    public int helper(int[] piles, int l, int r, int[][] dp) {
        if(l>r) {
            return 0;
        }
        if(dp[l][r]!=-1) return dp[l][r];
        boolean even = (r-l+1)%2 == 0;
        // int left = even ? piles[l] : 0;
        // int right = even ? piles[r] : 0;
        // dp[l][r] = Math.max(helper(piles,l + 1, r, dp) + left, helper(piles,l, r - 1, dp) + right);
        
        int x=0, y=0;
        if(even) {
            x = piles[l] + helper(piles,l+1,r,dp);
            y = piles[r] + helper(piles,l,r-1,dp);
        }
        else {
            x = helper(piles,l+1,r,dp);
            y = helper(piles,l,r-1,dp);
        }
        dp[l][r] = Math.max(x,y);
        return dp[l][r];
    }
}