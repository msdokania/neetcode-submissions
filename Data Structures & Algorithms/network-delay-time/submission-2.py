class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        adj = {src: [] for src in range(1,n+1)}
        q = []
        mintime = [float("inf")] * n
        mintime[k-1] = 0
        for t in times:
            adj[t[0]].append((t[2],t[1]))
        heapq.heappush(q, (0,k))
        while q:
            t, src = heapq.heappop(q)
            for wt, nxt in adj[src]:
                newtime = t + wt
                if newtime < mintime[nxt-1]:
                    mintime[nxt-1] = newtime
                    heapq.heappush(q, (newtime,nxt))
        ans = max(mintime)
        return ans if ans!=float("inf") else -1



# 1 -> (2,1), (4,4)
# 2 -> (3,1)
# 3
# 4

# mintime=

# (0,1)

# (1,2) (4,4)

# (2,3) (4,4)