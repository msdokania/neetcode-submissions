class Solution {
    class DSU {
        int[] parent;
        int comps;
        public DSU(int n) {
            parent = new int[n];
            comps = n;
            for(int i=0; i<n; i++)
                parent[i] = -1;
        }
        public int find(int node) {
            if(parent[node]<0) return node;
            return find(parent[node]);
        }
        public boolean union(int u, int v) {
            int pu=find(u), pv=find(v);
            if(pu==pv) return false;
            else if(pu>pv) {
                parent[pv] += parent[pu];
                parent[pu] = pv;
            }
            else {
                parent[pu] += parent[pv];
                parent[pv] = pu;
            }
            comps--;
            return true;
        }
        public int comp() {
            return comps;
        }
    }
    public boolean validTree(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        for(int[] e : edges) {
            if(!dsu.union(e[0],e[1]))
                return false;
        }
        return dsu.comp()==1? true : false;
    }
}
