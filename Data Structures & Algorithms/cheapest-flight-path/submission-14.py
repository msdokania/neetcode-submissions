class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        costarr = [float("inf")]*n
        costarr[src] = 0
        for _ in range(k+1):
            tmp = costarr.copy()
            for f,t,p in flights:
                newcost = min(tmp[t], costarr[f]+p)
                tmp[t] = newcost
            costarr = tmp
        return costarr[dst] if costarr[dst]!=float("inf") else -1