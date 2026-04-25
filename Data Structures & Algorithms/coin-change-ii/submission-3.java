class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        return helper(amount, coins, 0, 0, dp);
    }
    public int helper(int amount, int[] coins, int i, int curr, int[][] dp) {
        if(curr==amount) {
            return 1;
        }
        if(i>=coins.length || curr>amount)
            return 0;
        if(dp[i][curr]!=0)
            return dp[i][curr];
        for(int j=i; j<coins.length; j++) {
            dp[i][curr] += helper(amount, coins, j, curr+coins[j], dp);
        }
        return dp[i][curr];
    }
}
