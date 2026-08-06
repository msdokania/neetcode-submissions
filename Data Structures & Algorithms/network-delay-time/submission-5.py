class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        adj = defaultdict(list)
        for u,v,t in times:
            adj[u-1].append((v-1,t))
        mintime = [float("inf")]*n
        mintime[k-1] = 0
        q = deque()
        q.append((0,k-1))
        while q:
            currtime, u = q.popleft()
            if currtime>mintime[u]:
                continue
            for v,t in adj[u]:
                newtime = t+currtime
                if mintime[v]>newtime:
                    mintime[v] = newtime
                    q.append((newtime,v))
        x = max(mintime)
        return -1 if x==float("inf") else x