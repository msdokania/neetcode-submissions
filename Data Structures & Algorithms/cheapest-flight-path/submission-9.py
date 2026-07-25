class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        costarr = [float("inf")]*n
        costarr[src] = 0
        for _ in range(k+1):
            tmparr = costarr.copy()
            for u,v,p in flights:
                newprice = costarr[u]+p
                tmparr[v] = min(tmparr[v], newprice)
            costarr = tmparr
        return -1 if costarr[dst]==float("inf") else costarr[dst]

# adj: source: [(dest,price)]
# heap (price, stop, dest)
# costarr

# (200,1,1)
# if stop==k+1 and not dest

# ()