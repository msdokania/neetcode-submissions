class DSU:
    def __init__(self, n):
        self.parent = [-1] * n
        self.comp = n

    def find(self, u: int):
        if self.parent[u] < 0:
            return u
        return self.find(self.parent[u])

    def add(self, u: int, v: int) -> bool:
        pu,pv = self.find(u), self.find(v)
        if pu==pv:
            return False
        elif pu<pv:
            self.parent[pu] += self.parent[pv]
            self.parent[pv] = pu
        else:
            self.parent[pv] += self.parent[pu]
            self.parent[pu] = pv
        self.comp -= 1
        return True

    def getComp(self):
        return self.comp;

class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        dsu = DSU(n)
        for u,v in edges:
            if not dsu.add(u,v):
                return False
        x = dsu.getComp()
        return x==1
        


# 0   1   2   3   4
# -1  0   0   0   0

# 0   1     2     3       4
# -3  0     0     0      -1

# 0-1-2-3