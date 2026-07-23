class Solution:
    def minExtraChar(self, s: str, dictionary: List[str]) -> int:
        n = len(s)
        dp = [0]*(n+1)
        for i in range(n-1,-1,-1):
            dp[i] = 1+dp[i+1]
            for w in dictionary:
                ln = len(w)
                if i+ln<=n and s[i:i+ln]==w:
                    dp[i] = min(dp[i], dp[i+ln])
        return dp[0]

        
