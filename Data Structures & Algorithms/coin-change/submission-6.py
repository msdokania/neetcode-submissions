class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        n = len(coins)
        dp = [[float("inf")]*(amount+1) for _ in range(n)]
        for i in range(n):
            dp[i][0] = 0

        for i,c in enumerate(coins):
            for j in range(amount+1):
                if i>0:
                    dp[i][j] = dp[i-1][j]
                if c>j:
                    continue
                dp[i][j] = min(dp[i][j], dp[i][j-c]+1)
        return dp[n-1][amount] if dp[n-1][amount]!=float("inf") else -1