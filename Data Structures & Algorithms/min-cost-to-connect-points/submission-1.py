class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        adj = defaultdict(list)
        n = len(points)
        for i in range(n):
            for j in range(n):
                dist = abs(points[i][0]-points[j][0]) + abs(points[i][1]-points[j][1])
                adj[i].append((dist,j))
                adj[j].append((dist,i))
        q = [] # (cost,pt)
        ans = 0
        heapq.heappush(q, (0,0))
        vis = [False]*n

        while q:
            cost, pt = heapq.heappop(q)
            if vis[pt]:
                continue
            ans += cost
            vis[pt] = True
            for c,nxt in adj[pt]:
                if not vis[nxt]:
                    heapq.heappush(q, (c,nxt))
        return ans


