class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        adj = defaultdict(list)
        for t in times:
            adj[t[0]].append((t[1],t[2]))
        ans = [float("inf")]*n
        ans[k-1] = 0
        hp = []
        heapq.heappush(hp, (0,k))

        while hp:
            time,node = heapq.heappop(hp)
            if ans[node-1]<time:
                continue
            for nxt,t in adj[node]:
                newtime = ans[node-1] + t
                if newtime < ans[nxt-1]:
                    ans[nxt-1] = newtime
                    heapq.heappush(hp, (newtime,nxt))

        x = max(ans)
        if x==float("inf"):
            return -1
        return x



# ans = [0,1,2,3]
# adj: source: (dest,time)

# (time,which node) = heap
# (1,2) (4,4) 
# (2,3) (4,4)
# (3,4) (4,4)