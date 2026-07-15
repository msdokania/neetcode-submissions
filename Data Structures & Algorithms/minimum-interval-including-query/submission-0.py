class Solution:
    def minInterval(self, intervals: List[List[int]], queries: List[int]) -> List[int]:
        arr = []
        for i in range(len(intervals)):
            intr = intervals[i]
            arr.append((intr[0],0,intr[1]-intr[0]+1,i))
            arr.append((intr[1],2,intr[1]-intr[0]+1,i))
        for i in range(len(queries)):
            arr.append((queries[i],1,-1,i))
        arr.sort(key=lambda a: (a[0],a[1]))
        ans = [-1]*len(queries)
        active = []
        inactive = [False] * len(intervals)
        for val,typ,intr,idx in arr:
            if typ==0:
                heapq.heappush(active, (intr,idx))
            elif typ==2:
                inactive[idx] = True
            else:
                while active and inactive[active[0][1]]:
                    heapq.heappop(active)
                if active:
                    ans[idx] = active[0][0]
        return ans



