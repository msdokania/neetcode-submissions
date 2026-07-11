class Solution:
    def minimumEffortPath(self, heights: List[List[int]]) -> int:
        n,m = len(heights), len(heights[0])
        q = []
        vis = [[False]*m for _ in range(n)]
        dist = [[float("inf")]*m for _ in range(n)]
        dist[0][0] = 0
        heapq.heappush(q, (0,0,0))
        while q:
            ht, r,c = heapq.heappop(q)
            if vis[r][c]:
                continue
            if r==n-1 and c==m-1:
                return ht
            vis[r][c] = True
            for d in [[0,1],[1,0],[-1,0],[0,-1]]:
                nr,nc = r+d[0], c+d[1]
                if not nr in range(n) or not nc in range(m) or vis[nr][nc]:
                    continue
                diff = max(ht, abs(heights[nr][nc] - heights[r][c]))
                if diff < dist[nr][nc]:
                    dist[nr][nc] = diff
                    heapq.heappush(q, (diff,nr,nc))
        return -1 if dist[n-1][m-1]==float("inf") else dist[n-1][m-1]



# (0,0,0)

# (0,0,1) (2,1,0)

# (0,1,2) (1,1,1) (2,1,0)

