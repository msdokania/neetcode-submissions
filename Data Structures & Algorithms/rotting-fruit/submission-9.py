class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        n,m = len(grid), len(grid[0])
        q = deque()
        fresh = 0
        for i in range(n):
            for j in range(m):
                if grid[i][j]==1:
                    fresh += 1
                elif grid[i][j]==2:
                    q.append([i,j])
        time = 0
        if fresh==0:
            return time
        while q:
            siz = len(q)
            time += 1
            while siz>0:
                r,c = q.popleft()
                for d in [[0,1],[1,0],[-1,0],[0,-1]]:
                    nr,nc = r+d[0], c+d[1]
                    if nr<0 or nc<0 or nr>=n or nc>=m or grid[nr][nc]!=1:
                        continue
                    grid[nr][nc] = 2
                    fresh -= 1
                    q.append([nr,nc])
                siz -= 1
                if fresh==0:
                    return time
                
        return -1
