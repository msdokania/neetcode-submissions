class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        dp = [[False]*n for _ in range(n)]
        ans = [0]*2
        maxlen = 1
        for i in range(n-1, -1, -1):
            for j in range(i, n):
                if s[i]==s[j] and (j-i<=2 or dp[i+1][j-1]):
                    dp[i][j] = True
                    if j-i+1 > maxlen:
                        ans[0], ans[1] = i, j
                        maxlen = j-i+1
        return s[ans[0]:ans[1]+1]

            