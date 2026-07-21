class Solution:
    def lastStoneWeightII(self, stones: List[int]) -> int:
        total1 = sum(stones)
        total = total1//2
        n = len(stones)
        dp = [[0]*(total+1) for _ in range(n+1)]
        for i in range(n):
            for j in range(total+1):
                x = stones[i]
                if x<=j:
                    dp[i+1][j] = max(dp[i][j], x + dp[i][j-x])
                else:
                    dp[i+1][j] = dp[i][j]
        a = dp[n][total]
        b = total1-a
        return abs(a-b)