class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        n = len(tickets)
        tickets.sort()
        adj = {src: [] for src,_ in tickets}
        for src,dst in tickets:
            adj[src].append(dst)
        ans = ["JFK"]

        def travel(src: str) -> bool:
            if len(ans) == n+1:
                return True
            if src not in adj:
                return False
            lst = adj[src]
            for i,nxt in enumerate(lst):
                lst.pop(i)
                ans.append(nxt)
                if travel(nxt):
                    return True
                lst.insert(i,nxt)
                ans.pop()
            return False

        travel("JFK")
        return ans



# JFK: [HOU, SEA]
# ..

# ans = JFK

# JFK
# HOU, 
# JFK
# SEA
# JFK