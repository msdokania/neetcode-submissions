class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        n,m = len(grid), len(grid[0])
        ans = 0

        def dfs(r: int, c: int):
            if r<0 or c<0 or r>=n or c>=m or grid[r][c]!="1":
                return
            grid[r][c] = "0"
            dfs(r+1,c)
            dfs(r-1,c)
            dfs(r,c+1)
            dfs(r,c-1)

        for i in range(n):
            for j in range(m):
                if grid[i][j]=="1":
                    dfs(i,j)
                    ans += 1
        return ans