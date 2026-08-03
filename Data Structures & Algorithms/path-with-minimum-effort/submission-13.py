class Solution:
    def minimumEffortPath(self, heights: List[List[int]]) -> int:
        m,n = len(heights), len(heights[0])
        dist = [[float("inf")]*n for _ in range(m)]
        dist[0][0] = 0
        q = []
        heapq.heappush(q, (0,0,0))
        vis = set()
        while q:
            cost,r,c = heapq.heappop(q)
            vis.add((r,c))
            for nr,nc in [(r+1,c),(r-1,c),(r,c+1),(r,c-1)]:
                if not 0<=nr<m or not 0<=nc<n or (nr,nc) in vis:
                    continue
                diff = abs(heights[nr][nc]-heights[r][c])
                newcost = max(dist[r][c], diff)
                if newcost<dist[nr][nc]:
                    dist[nr][nc] = newcost
                    heapq.heappush(q,(newcost,nr,nc))
        return dist[m-1][n-1] if dist[m-1][n-1]!=float("inf") else -1
