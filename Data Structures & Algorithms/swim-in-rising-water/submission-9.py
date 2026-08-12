class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        n = len(grid)
        timearr = [[float("inf")]*n for _ in range(n)]
        timearr[0][0] = grid[0][0]
        q = [(grid[0][0],0,0)]
        # q.append((grid[0][0],0,0))
        while q:
            t,r,c = heapq.heappop(q)
            if timearr[r][c]<t:
                continue
            if r==n-1 and c==n-1:
                return t
            for nr,nc in [(r+1,c),(r-1,c),(r,c+1),(r,c-1)]:
                if not 0<=nr<n or not 0<=nc<n:
                    continue
                newtime = t
                if grid[nr][nc]>newtime:
                    newtime = grid[nr][nc]
                if timearr[nr][nc]>newtime:
                    timearr[nr][nc] = newtime
                    heapq.heappush(q,(newtime,nr,nc))
                    # q.append((newtime,nr,nc))
        return timearr[n-1][n-1]