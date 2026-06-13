class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        n,m = len(grid), len(grid[0])
        ans = 0

        def dfs(r: int, c: int):
            if r<0 or c<0 or r>=n or c>=m or grid[r][c]==0:
                return 0
            grid[r][c] = 0
            a1 = dfs(r+1,c)
            a2 = dfs(r-1,c)
            a3 = dfs(r,c+1)
            a4 = dfs(r,c-1)
            return 1+a1+a2+a3+a4

        for i in range(n):
            for j in range(m):
                if grid[i][j]==1:
                    area = dfs(i,j)
                    ans = max(ans, area)
        return ans