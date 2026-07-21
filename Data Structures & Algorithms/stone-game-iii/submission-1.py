class Solution:
    def stoneGameIII(self, stoneValue: List[int]) -> str:
        n = len(stoneValue)
        dp = [float("-inf")]*(n+1)
        dp[n] = 0
        for i in range(n-1,-1,-1):
            take1 = stoneValue[i]-dp[i+1]
            take2, take3 = float("-inf"),float("-inf")
            if i+1 < n:
                take2 = sum(stoneValue[i:i+2]) - dp[i+2]
            if i+2 < n:
                take3 = sum(stoneValue[i:i+3]) - dp[i+3]
            dp[i] = max(dp[i],take1,take2,take3)
        if dp[0]==0:
            return "Tie"
        return "Alice" if dp[0]>0 else "Bob"
