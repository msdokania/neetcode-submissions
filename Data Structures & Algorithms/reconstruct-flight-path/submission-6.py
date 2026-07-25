class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        n = len(tickets)
        adj = defaultdict(list)
        for t in tickets:
            adj[t[0]].append(t[1])
        for k in adj.keys():
            adj[k].sort()
        ans = ["JFK"]

        def dfs(source):
            for i,nxt in enumerate(adj[source]):
                adj[source].remove(nxt)
                ans.append(nxt)
                dfs(nxt)
                if len(ans)==n+1:
                    break
                ans.pop()
                adj[source].insert(i,nxt)

        dfs("JFK")
        return ans



# adj: source: [dest] (sort)

# JFK, BUF, HOU, SEA
