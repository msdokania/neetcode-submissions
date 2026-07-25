class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        adj = defaultdict(list)
        for f in flights:
            adj[f[0]].append((f[1],f[2]))
        costarr = [float("inf")]*n
        costarr[0] = 0
        q = []
        heapq.heappush(q, (0,0,src))

        while q:
            currp,stop,apt = heapq.heappop(q)
            if apt==dst:
                return currp
            for nxt,price in adj[apt]:
                newprice = currp+price
                if stop==k and nxt!=dst:
                    continue
                costarr[nxt] = newprice
                heapq.heappush(q, (newprice,stop+1,nxt))

        return -1

# adj: source: [(dest,price)]
# heap (price, stop, dest)
# costarr

# (200,1,1)
# if stop==k+1 and not dest

# ()