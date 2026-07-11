class Solution:
    def foreignDictionary(self, words: List[str]) -> str:
        n = len(words)
        adj = {c: set() for w in words for c in w}
        indeg = {c: 0 for c in adj}
        for i in range(n-1):
            w1, w2 = words[i], words[i+1]
            a,b = 0,0
            while a<len(w1) and b<len(w2) and w1[a]==w2[b]:
                a += 1
                b += 1
            if b==len(w2) and a!=len(w1):
                return ""
            if a!=len(w1):
                if w2[b] not in adj[w1[a]]:
                    adj[w1[a]].add(w2[b])
                    indeg[w2[b]] += 1

        q = deque()
        ans = ""
        for tmp in indeg:
            if indeg[tmp]==0:
                q.append(tmp)
        while q:
            tmp = q.popleft()
            ans += tmp
            for x in adj[tmp]:
                indeg[x] -= 1
                if indeg[x]==0:
                    q.append(x)
        if len(ans)!=len(indeg):
            return ""
        return ans

                
                


