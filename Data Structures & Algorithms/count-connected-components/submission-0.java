class Solution {
    class DSU {
        int[] parent;
        int comp;
        public DSU(int n) {
            parent = new int[n+1];
            comp = n;
            for(int i=0; i<=n; i++)
                parent[i] = -1;
        }
        public int find(int node) {
            if(parent[node] < 0)
                return node;
            return find(parent[node]);
        }
        public boolean union(int u, int v) {
            int pu = find(u);
            int pv = find(v);
            if(pv==pu) return false;
            if(parent[pu] >= parent[pv]) {
                parent[pv] += parent[pu];
                parent[pu] = pv;
            }
            else {
                parent[pu] += parent[pv];
                parent[pv] = pu;
            }
            comp--;
            return true;
        }
        public int components() {
            return comp;
        }
    }
    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        for(int[] edge : edges) {
            dsu.union(edge[0], edge[1]);
        }
        return dsu.components();
    }
}
