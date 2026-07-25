class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        n,m = len(grid), len(grid[0])
        timarr = [[float("inf")]*m for _ in range(n)]
        timarr[0][0] = grid[0][0]
        vis = [[False]*m for _ in range(n)]
        q = []
        heapq.heappush(q, (grid[0][0],0,0))

        while q:
            t,r,c = heapq.heappop(q)
            if vis[r][c] or timarr[r][c]<t:
                continue
            for d in [[0,1],[1,0],[-1,0],[0,-1]]:
                nr,nc = r+d[0], c+d[1]
                if nr not in range(n) or nc not in range(m) or vis[nr][nc]:
                    continue
                newtime = max(t,grid[nr][nc])
                if timarr[nr][nc] > newtime:
                    timarr[nr][nc] = newtime
                    heapq.heappush(q, (newtime,nr,nc))
        return timarr[n-1][m-1] if timarr[n-1][m-1]!=float("inf") else -1

