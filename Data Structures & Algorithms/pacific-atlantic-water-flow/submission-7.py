class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        n,m = len(heights), len(heights[0])
        pac = [[False] * m for _ in range(n)]
        at = [[False] * m for _ in range(n)]

        def dfs(r: int,c: int, arr: List[int]):
            arr[r][c] = True
            for dr,dc in [[0,1],[1,0],[-1,0],[0,-1]]:
                nr, nc = r+dr, c+dc
                if nr in range(n) and nc in range(m) and not arr[nr][nc] and heights[nr][nc]>=heights[r][c]:
                    dfs(nr,nc,arr)

        for i in range(n):
            dfs(i,0,pac)
            dfs(i,m-1,at)
        for j in range(m):
            dfs(0,j,pac)
            dfs(n-1,j,at)
        ans = []
        for i in range(n):
             for j in range(m):
                if pac[i][j] and at[i][j]:
                    ans.append([i,j])
        return ans
