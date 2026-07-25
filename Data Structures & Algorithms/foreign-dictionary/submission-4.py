class Solution:
    def foreignDictionary(self, words: List[str]) -> str:
        adj = defaultdict(set)
        indegree = {c:0 for w in words for c in w}
        for i in range(len(words)-1):
            w1,w2 = words[i],words[i+1]
            j=0
            while j<min(len(w1),len(w2)):
                if w1[j]!=w2[j]:
                    break
                j += 1
            if j==len(w2) and j!=len(w1):
                return ""
            if j<len(w1):
                if w2[j] not in adj[w1[j]]:
                    adj[w1[j]].add(w2[j])
                    indegree[w2[j]] += 1
            
        ans = ""
        q = deque()
        for k in indegree.keys():
            if indegree[k]==0:
                q.append(k)

        while q:
            curr = q.pop()
            ans += curr
            for nx in adj[curr]:
                indegree[nx] -= 1
                if indegree[nx]==0:
                    q.append(nx)
        return "" if len(ans)!=len(indegree) else ans
