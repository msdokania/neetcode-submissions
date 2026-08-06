class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        adj = defaultdict(list)
        for u,v,t in times:
            adj[u-1].append((v-1,t))
        mintime = [float("inf")]*n
        mintime[k-1] = 0
        q = []
        heapq.heappush(q, (0,k-1))
        vis = set()
        ans = 0
        while q:
            currtime, u = heapq.heappop(q)
            if u in vis:
                continue
            ans = currtime
            for v,t in adj[u]:
                newtime = t+currtime
                if v not in vis:
                    heapq.heappush(q, (newtime,v))
            vis.add(u)
        if len(vis)!=n: return -1
        return ans