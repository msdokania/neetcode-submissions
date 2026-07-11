class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        n = len(grid)
        mintime = [[float("inf")]*n for _ in range(n)]
        vis = [[False]*n for _ in range(n)]
        q = []
        heapq.heappush(q, (grid[0][0],0,0))
        while q:
            t,r,c = heapq.heappop(q)
            if r==n-1 and c==n-1:
                return t
            vis[r][c] = True
            for d in [[0,1],[1,0],[-1,0],[0,-1]]:
                nr,nc = r+d[0], c+d[1]
                if nr not in range(n) or nc not in range(n) or vis[nr][nc]: # vis
                    continue
                newtime = max(t, grid[nr][nc])
                if newtime < mintime[nr][nc]:
                    mintime[nr][nc] = newtime
                    heapq.heappush(q, (newtime, nr,nc))
        return -1




