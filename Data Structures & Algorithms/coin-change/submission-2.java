class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int i=1; i<=amount; i++) {
            for(int coin : coins) {
                if(coin>i) continue;
                // if(amount%coin==0) {
                //     dp[i] = Math.min(dp[i], x);
                // } else {

                // }
                int x = i/coin;
                dp[i] = Math.min(dp[i], 1+dp[i-coin]);
            }
        }
        return dp[amount]==amount+1? -1 : dp[amount];
    }
}


// 1: 1
// 2: 2
// 3: 3
// 4: 4
// 5: 1
// 6: 6