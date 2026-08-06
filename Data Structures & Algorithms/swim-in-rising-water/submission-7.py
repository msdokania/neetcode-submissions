class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        n = len(grid)
        dist = [[float("inf")]*n for _ in range(n)]
        dist[0][0] = grid[0][0]
        q = []
        heapq.heappush(q, (grid[0][0],0,0))
        while q:
            currcost,r,c = heapq.heappop(q)
            if dist[r][c]<currcost:
                continue
            if r==n-1 and c==n-1:
                return currcost
            for nr,nc in [(r+1,c),(r-1,c),(r,c+1),(r,c-1)]:
                if not 0<=nr<n or not 0<=nc<n:
                    continue
                newht = currcost
                if grid[nr][nc]>currcost:
                    newht = grid[nr][nc]
                if dist[nr][nc] > newht:
                    dist[nr][nc] = newht
                    heapq.heappush(q, (newht,nr,nc))
        return -1
                