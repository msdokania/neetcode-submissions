class Solution {
    class DSU {
        int[] parent;
        int elemCount;
        public DSU(int n) {
            parent = new int[n+1];
            elemCount = n;
            for(int i=0; i<=n; i++)
                parent[i] = -1;
        }
        public int find(int u) {
            if(parent[u] < 0) {
                return u;
            }
            return find(parent[u]);
        }
        public boolean union(int u, int v) {
            int pu = find(u);
            int pv = find(v);
            if(pu==pv) return false;
            if(parent[pu] >= parent[pv]) {
                parent[pv] += parent[pu];
                parent[pu] = pv;
            }
            else{
                parent[pu] += parent[pv];
                parent[pv] = pu;
            }
            elemCount--;
            return true;
        }
        public int components() {
            return elemCount;
        }
    }
    public boolean validTree(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        for(int[] edge : edges) {
            if(!dsu.union(edge[0], edge[1])) return false;
        }
        return dsu.components() == 1;
    }
}
