class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        cost = [float("inf")]*n
        cost[src] = 0
        for i in range(k+1):
            tmp = cost.copy()
            for f in flights:
                newcost = cost[f[0]]+f[2]
                if cost[f[0]]!=float("inf"):
                    tmp[f[1]] = min(tmp[f[1]], newcost)
            cost = tmp
        return cost[dst] if cost[dst]!=float("inf") else -1
        