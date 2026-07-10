class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        n = len(s)
        dp = [False]*n
        words = set(wordDict)
        for i in range(n):
            if i!=0 and dp[i-1]==False:
                continue
            for j in range(n):
                if s[i:j+1] in words:
                    dp[j] = True
            if dp[n-1]:
                return True
        return False


