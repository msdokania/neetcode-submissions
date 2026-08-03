class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        n = len(grid)
        ht = [[float("inf")]*n for _ in range(n)]
        ht[0][0] = grid[0][0]
        q = []
        heapq.heappush(q, (grid[0][0],0,0))
        vis = set()
        vis.add((0,0))
        while q:
            t,r,c = heapq.heappop(q)
            if r==n-1 and c==n-1:
                return t
            for nr,nc in [(r+1,c),(r-1,c),(r,c+1),(r,c-1)]:
                if not 0<=nr<n or not 0<=nc<n or (nr,nc) in vis:
                    continue
                newt = t
                if grid[nr][nc]>=newt:
                    newt = grid[nr][nc]
                vis.add((nr,nc))
                ht[nr][nc] = min(ht[nr][nc], newt)
                heapq.heappush(q, (newt,nr,nc))
        return -1