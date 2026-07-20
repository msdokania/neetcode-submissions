class Solution:
    def numSquares(self, n: int) -> int:
        ans = 0
        dp = [float("inf")]*(n+1)
        dp[0] = 0

        for i in range(1,n+1):
            k = 1
            while k*k<=i:
                dp[i] = min(1+dp[i-k*k], dp[i])
                k += 1
        return dp[n]

