class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        adj = defaultdict(list)
        for t in tickets:
            adj[t[0]].append(t[1])
        for t in adj.keys():
            adj[t].sort()
        ans = ["JFK"]

        def dfs(src):
            for i,nxt in enumerate(adj[src]):
                ans.append(nxt)
                adj[src].remove(nxt)
                if dfs(nxt):
                    return True
                adj[src].insert(i,nxt)
                ans.pop()
            return len(ans)==len(tickets)+1

        dfs("JFK")
        return ans