class Solution:
    def minimumEffortPath(self, heights: List[List[int]]) -> int:
        n,m = len(heights), len(heights[0])
        q = []
        heapq.heappush(q, (0,0,0))
        dist = [[1000001]*m for _ in range(n)]
        while q:
            curr, r, c = heapq.heappop(q)
            for d in [[0,1],[1,0],[-1,0],[0,-1]]:
                nr, nc = r+d[0], c+d[1]
                if nr not in range(n) or nc not in range(m):
                    continue
                wt = max(curr, abs(heights[nr][nc] - heights[r][c]))
                if wt < dist[nr][nc]:
                    heapq.heappush(q, (wt,nr,nc))
                    dist[nr][nc] = wt
        return 0 if dist[n-1][m-1]==1000001 else dist[n-1][m-1]

# vis - (0,0)

# (0,0,1) (2,1,0)

# (0,1,2) (1,1,1) (2,1,0)

# (1,1,1) (2,1,0) (3,1,2)
