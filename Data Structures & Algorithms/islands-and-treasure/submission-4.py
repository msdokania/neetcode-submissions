class Solution:
    def islandsAndTreasure(self, grid: List[List[int]]) -> None:
        n,m = len(grid), len(grid[0])
        q = deque()
        INF = 2147483647
        for i in range(n):
            for j in range(m):
                if grid[i][j]==0:
                    q.append([i,j])
        step = 1
        while q:
            siz = len(q)
            while siz>0:
                r,c = q.popleft()
                for d in [[0,1],[1,0],[-1,0],[0,-1]]:
                    nr,nc = r+d[0], c+d[1]
                    if nr<0 or nc<0 or nr>=n or nc>=m or grid[nr][nc]!=INF:
                        continue
                    grid[nr][nc] = step
                    q.append([nr,nc])
                siz -= 1
            step += 1
