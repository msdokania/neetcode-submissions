class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        time = [float("inf")]*n
        time[k-1] = 0
        adj = [[] for _ in range(n)]
        q = []
        heapq.heappush(q, (0,k))
        for lst in times:
            adj[lst[0]-1].append((lst[1],lst[2]))
        while q:
            currtime, currnode = heapq.heappop(q)
            for itr in adj[currnode-1]:
                nxt, t = itr[0], itr[1]
                x = t + currtime
                if time[nxt-1] > x:
                    time[nxt-1] = x
                    heapq.heappush(q, (x,nxt))
        ans = max(time)
        return ans if ans!=float("inf") else -1

# 0 1 2 4
# n=4

# (0,1)

# (1,2) (4,4)

# (2,3) (4,4)