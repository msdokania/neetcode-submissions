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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> ans = new ArrayList<>();
        int n = accounts.size();
        DSU dsu = new DSU(n);
        Map<String, Integer> emailtoacc = new HashMap<>();
        for(int i=0; i<n; i++) {
            for(int j=1; j<accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if(emailtoacc.containsKey(email)) {
                    dsu.union(i, emailtoacc.get(email));
                }
                else {
                    emailtoacc.put(email, i);
                }
            }
        }
        Map<Integer, List<String>> emailgrp = new HashMap<>();
        for(String x : emailtoacc.keySet()) {
            int acc = emailtoacc.get(x);
            int parent = dsu.find(acc);
            List<String> tmp = emailgrp.getOrDefault(parent, new ArrayList<>());
            tmp.add(x);
            emailgrp.put(parent, tmp);
        }
        for(int x : emailgrp.keySet()) {
            List<String> lst = new ArrayList<>();
            lst.add(accounts.get(x).get(0));
            for(String s : emailgrp.get(x)) {
                lst.add(s);
            }
            ans.add(lst);
        }
        return ans;
    }
}






