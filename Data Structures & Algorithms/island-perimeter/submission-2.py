class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        n, m = len(grid), len(grid[0])

        def dfs(r: int, c: int):
            if r<0 or r>=n or c<0 or c>=m or grid[r][c]==0:
                return 1
            if grid[r][c]==-1:
                return 0
            grid[r][c] = -1
            return dfs(r+1,c) + dfs(r-1,c) + dfs(r,c+1) + dfs(r,c-1)

        for i in range(n):
            for j in range(m):
                if grid[i][j]==1:
                    return dfs(i,j)
        return 0