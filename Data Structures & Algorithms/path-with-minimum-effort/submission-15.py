class Solution:
    def minimumEffortPath(self, heights: List[List[int]]) -> int:
        m,n = len(heights), len(heights[0])
        dist = [[float("inf")]*n for _ in range(m)]
        q = []
        heapq.heappush(q, (0,0,0))
        while q:
            curr,r,c = heapq.heappop(q)
            if dist[r][c]<curr:
                continue
            if r==m-1 and c==n-1:
                return curr
            for nr,nc in [(r+1,c),(r-1,c),(r,c+1),(r,c-1)]:
                if not 0<=nr<m or not 0<=nc<n:
                    continue
                neweffort = max(curr, abs(heights[nr][nc]-heights[r][c]))
                if dist[nr][nc]>neweffort:
                    dist[nr][nc] = neweffort
                    heapq.heappush(q, (neweffort,nr,nc))
        return -1