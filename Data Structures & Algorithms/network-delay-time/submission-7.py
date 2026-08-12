class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        timearr = [float("inf")]*n
        timearr[k-1] = 0
        adj = defaultdict(list)
        for u,v,t in times:
            adj[u].append((v,t))
        q = deque()
        q.append((0,k))
        while q:
            currtime,u = q.popleft()
            if timearr[u-1]<currtime:
                continue
            for v,t in adj[u]:
                newtime = t+currtime
                if newtime<timearr[v-1]:
                    timearr[v-1] = newtime
                    q.append((newtime,v))
        ans = max(timearr)
        return ans if ans!=float("inf") else -1