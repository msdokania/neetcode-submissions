class Solution:
    def foreignDictionary(self, words: List[str]) -> str:
        adj = defaultdict(list)
        indegree = {x: 0 for w in words for x in w}
        for i in range(len(words)-1):
            w1,w2 = words[i],words[i+1]
            i = 0
            while i<min(len(w1),len(w2)) and w1[i]==w2[i]:
                i += 1
            if i==len(w2) and i!=len(w1):
                return ""
            if i!=len(w1):
                adj[w1[i]].append(w2[i])
                indegree[w2[i]] += 1
        q = deque()
        for k in indegree.keys():
            if indegree[k]==0:
                q.append(k)
        ans = []
        while q:
            curr = q.popleft()
            ans.append(curr)
            for nxt in adj[curr]:
                indegree[nxt] -= 1
                if indegree[nxt]==0:
                    q.append(nxt)
        return "".join(ans) if len(ans)==len(indegree) else ""