class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        adj = defaultdict(list)
        n = len(points)
        for i in range(n):
            for j in range(n):
                if i!=j:
                    dist = abs(points[i][0]-points[j][0]) + abs(points[i][1]-points[j][1])
                    adj[i].append((j,dist))
        q = [(0,0)]
        used = set()
        ans = 0
        while q:
            curr,pt = heapq.heappop(q)
            if pt in used:
                continue
            used.add(pt)
            ans += curr
            for nxt,c in adj[pt]:
                if nxt not in used:
                    heapq.heappush(q,(c, nxt))
            if len(used)==n:
                return ans
        return ans
