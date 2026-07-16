class Solution:
    def minInterval(self, intervals: List[List[int]], queries: List[int]) -> List[int]:
        intervals.sort()
        n,m = len(intervals), len(queries)
        active = []
        minheap = []
        qarr = []
        for q in range(m):
            qarr.append((queries[q],q))
        qarr.sort()
        i = 0
        ans = [-1]*m
        for q,idx in qarr:
            while i<n and intervals[i][0]<=q:
                heapq.heappush(active, (intervals[i][1]-intervals[i][0]+1, intervals[i][1]))
                i += 1
            while active and active[0][1]<q:
                heapq.heappop(active)
            if active:
                ans[idx] = active[0][0]
        return ans
            
