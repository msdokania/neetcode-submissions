class Solution:
    def minInterval(self, intervals: List[List[int]], queries: List[int]) -> List[int]:
        n,m = len(intervals), len(queries)
        intarray = [] # (x, typ, interval, idx)
        active = []
        inactive = [False] * n
        ans = [-1] * m
        for i in range(n):
            duration = intervals[i][1]-intervals[i][0]+1
            intarray.append((intervals[i][0],0,duration,i))
            intarray.append((intervals[i][1],2,duration,i))
        for i in range(m):
            intarray.append((queries[i],1,0,i))
        intarray.sort()

        for x,typ,dur,idx in intarray:
            if typ==0:
                heapq.heappush(active, (dur,idx))
            elif typ==2:
                inactive[idx] = True
            else:
                while active and inactive[active[0][1]]:
                    heapq.heappop(active)
                if active:
                    ans[idx] = active[0][0]
        return ans
