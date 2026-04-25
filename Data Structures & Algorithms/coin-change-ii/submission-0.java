class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        return helper(coins, amount, dp, 0, 0);
        // return dp[n-1][amount];
    }
    public int helper(int[] coins, int amount, int[][] dp, int i, int curr) {
        if(i>=coins.length || curr>amount)
            return 0;
        if(dp[i][curr]!=0)
            return dp[i][curr];
        if(curr==amount) return 1;
        for(int j=i; j<coins.length; j++) {
            dp[i][curr] += helper(coins, amount, dp, j, curr+coins[j]);
        }
        return dp[i][curr];
    }
}
