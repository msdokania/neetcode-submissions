class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        n,m = len(matrix), len(matrix[0])
        dp = [[0]*m for _ in range(n)]
        ans = 0

        def helper(r,c):
            if dp[r][c]!=0:
                return dp[r][c]
            res = 1
            for d in [[0,1],[1,0],[-1,0],[0,-1]]:
                nr,nc = r+d[0], c+d[1]
                if nr not in range(n) or nc not in range(m) or matrix[nr][nc] <= matrix[r][c]:
                    continue
                res = max(res, 1+helper(nr,nc))
            dp[r][c] = res
            return dp[r][c]
                
                
        for i in range(n):
            for j in range(m):
                ans = max(ans, helper(i,j))
        return ans