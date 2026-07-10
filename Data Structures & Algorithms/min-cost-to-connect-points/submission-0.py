class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        n = len(points)
        adj = {i: [] for i in range(n)}
        for i in range(n):
            for j in range(n):
                dist = abs(points[i][0]-points[j][0]) + abs(points[i][1]-points[j][1])
                adj[i].append((j,dist))
                adj[j].append((i,dist))
        q = []
        visit = set()
        heapq.heappush(q, (0,0))
        ans = 0
        while q:
            cost, pt = heapq.heappop(q)
            if pt in visit:
                continue
            visit.add(pt)
            ans += cost
            if len(visit)==n:
                return ans
            for nei, c in adj[pt]:
                if nei not in visit:
                    heapq.heappush(q, (c,nei))
        return ans