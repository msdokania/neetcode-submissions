class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        return helper(coins, amount, 0,0, dp);
    }
    public int helper(int[] coins, int amount, int i, int curr, int[][] dp) {
        if(curr==amount) {
            return 1;
        }
        if(i==coins.length || curr>amount)
            return 0;
        if(dp[i][curr] != 0)
            return dp[i][curr];
        for(int j=i; j<coins.length; j++)
            dp[i][curr] += helper(coins, amount, j, curr+coins[j], dp);
        return dp[i][curr];
    }
}

// 1111
// 1112 1113
// 112
// 122
// 13
