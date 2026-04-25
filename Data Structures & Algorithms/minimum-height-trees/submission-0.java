class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> leaves = new ArrayList<>();
        if(n==0) return leaves;
        if(n==1) {
            leaves.add(0);
            return leaves;
        }
        List<Set<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++)
            adj.add(new HashSet<>());
        for(int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        for(int i=0; i<n; i++) {
            if(adj.get(i).size()==1) leaves.add(i);
        }
        int centroids = n;
        while(centroids>2) {
            List<Integer> newleaves = new ArrayList<>();
            for(int l : leaves) {
                int par = adj.get(l).iterator().next();
                adj.get(par).remove(l);
                if(adj.get(par).size()==1)
                    newleaves.add(par);
            }
            centroids -= leaves.size();
            leaves = newleaves;
        }
        return leaves;
    }
}

// 1. create adj list - graph
// 2. get all leaves
// 3. one by one remove itself
// 4. if in doing the above, a node becomes leaf add to new set if leaves