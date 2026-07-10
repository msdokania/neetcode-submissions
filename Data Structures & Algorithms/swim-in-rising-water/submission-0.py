class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        n = len(grid)
        ans = [[float("inf")]*n for _ in range(n)]
        q = []
        heapq.heappush(q, (grid[0][0], 0, 0))
        vis = [[False]*n for _ in range(n)]
        while q:
            t,r,c = heapq.heappop(q)
            if vis[r][c]:
                continue
            vis[r][c] = True
            for d in [[0,1],[1,0],[-1,0],[0,-1]]:
                nr,nc = r+d[0], c+d[1]
                if not nr in range(n) or not nc in range(n) or vis[nr][nc]:
                    continue
                newtime = max(grid[nr][nc], t)
                if newtime < ans[nr][nc]:
                    ans[nr][nc] = newtime
                    heapq.heappush(q, (ans[nr][nc], nr, nc))
        return -1 if ans[n-1][n-1]==float("inf") else ans[n-1][n-1]


# on adding in heap put in seen
# (0,0,0)

# (1,0,1) (9,1,0) t=1 (pop till ht<=t) if first >t, edit t

# (2,0,2) (9,1,0) (14,1,1) 

# (4,1,2) (9,1,0) (10,0,3) (14,1,1)

# (8,2,2) (9,1,0) (10,0,3) (13,1,3) (14,1,1) t=8

# (3,2,1) (7,3,2) (9,1,0) (10,0,3) (13,1,3) (14,1,1) (15,2,3) t=8

