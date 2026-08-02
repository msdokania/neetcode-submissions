class UnionFind:
    def __init__(self, n):
        self.par = [i for i in range(n)]
        self.rank = [1] * n

    def find(self, x):
        while x != self.par[x]:
            self.par[x] = self.par[self.par[x]]
            x = self.par[x]
        return x

    def union(self, x1, x2):
        p1, p2 = self.find(x1), self.find(x2)
        if p1 == p2:
            return False
        if self.rank[p1] > self.rank[p2]:
            self.par[p2] = p1
            self.rank[p1] += self.rank[p2]
        else:
            self.par[p1] = p2
            self.rank[p2] += self.rank[p1]
        return True

class Solution:
    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        email_idx = defaultdict(list)
        n = len(accounts)
        dsu = UnionFind(n)
        for i in range(n):
            acc = accounts[i]
            for a in acc[1:]:
                if a in email_idx:
                    dsu.union(email_idx[a],i)
                else:
                    email_idx[a] = i

        idtoemail = defaultdict(list)
        for k in email_idx.keys():
            x = dsu.find(email_idx[k])
            idtoemail[x].append(k)

        ans = []
        for k in idtoemail.keys():
            curr = [accounts[k][0]]
            curr.extend(idtoemail[k])
            ans.append(curr)
        return ans 