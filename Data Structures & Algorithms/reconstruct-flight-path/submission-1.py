class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        n = len(tickets)
        tickets.sort()
        adj = {src: [] for src,dst in tickets}
        for s,d in tickets:
            adj[s].append(d)
        ans = ["JFK"]

        def dfs(source: str):
            if len(ans) == n + 1:
                return True
            if source not in adj:
                return False
            tmp = adj[source]
            for i, nxt in enumerate(tmp):
                tmp.pop(i)
                ans.append(nxt)
                if dfs(nxt):
                    return True
                tmp.insert(i,nxt)
                ans.pop()
            return False
        
        dfs("JFK")
        return ans
        



