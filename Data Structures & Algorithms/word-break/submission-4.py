class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        i=0
        n = len(s)
        dp = [False]*n
        while i<n:
            if i!=0 and not dp[i-1]:
                i += 1
                continue
            for word in wordDict:
                ln = len(word)
                if i+ln > n:
                    continue
                if s[i:i+ln] == word:
                    dp[i+ln-1] = True
            if dp[n-1]:
                return True
                
            i += 1
        return dp[n-1]