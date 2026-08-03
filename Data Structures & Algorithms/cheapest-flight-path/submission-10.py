class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        cost = [float("inf")]*n
        cost[src] = 0
        for _ in range(k+1):
            tmp = cost.copy()
            for s,d,p in flights:
                price = min(tmp[d], cost[s]+p)
                tmp[d] = price
            cost = tmp
        return cost[dst] if cost[dst]!=float("inf") else -1
        
