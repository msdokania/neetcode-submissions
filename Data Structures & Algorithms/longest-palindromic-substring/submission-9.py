class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        dp = [[False]*n for _ in range(n)]
        ans = [0]*2
        maxlen = 1
        for i in range(n):
            dp[i][i] = True
            if i!=n-1 and s[i]==s[i+1]:
                dp[i][i+1] = True
                ans[0], ans[1] = i, i+1
                maxlen = 2
        for i in range(n-3, -1, -1):
            for j in range(i+2, n):
                if s[i]==s[j]:
                    dp[i][j] = dp[i+1][j-1]
                    if dp[i][j] and j-i+1 > maxlen:
                        ans[0], ans[1] = i, j
                        maxlen = j-i+1
        return s[ans[0]:ans[1]+1]

            