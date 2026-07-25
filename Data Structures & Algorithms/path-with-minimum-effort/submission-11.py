class Solution:
    def minimumEffortPath(self, heights: List[List[int]]) -> int:
        n,m = len(heights), len(heights[0])
        dist = [[float("inf")]*m for _ in range(n)]
        dist[0][0] = 0
        vis = [[False]*m for _ in range(n)]
        q = []
        heapq.heappush(q, (0,0,0))
        while q:
            curreff,r,c = heapq.heappop(q)
            if r==n-1 and c==m-1:
                return curreff
            if curreff>dist[r][c] or vis[r][c]:
                continue
            for d in [[0,1],[1,0],[-1,0],[0,-1]]:
                nr,nc = r+d[0], c+d[1]
                if nr not in range(n) or nc not in range(m) or vis[nr][nc]:
                    continue
                effort = abs(heights[nr][nc]-heights[r][c])
                maxeffort = max(effort, dist[r][c])
                if dist[nr][nc]>maxeffort:
                    dist[nr][nc] = maxeffort
                    heapq.heappush(q, (dist[nr][nc],nr,nc))                
            vis[r][c] = True

        return dist[n-1][m-1] if dist[n-1][m-1]!=float("inf") else -1

