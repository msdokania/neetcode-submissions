class Solution {
    public int findJudge(int n, int[][] trust) {
        Map<Integer, Integer> inc = new HashMap<>();
        Map<Integer, Integer> out = new HashMap<>();
        for(int[] x : trust) {
            inc.put(x[1], inc.getOrDefault(x[1],0)+1);
            out.put(x[0], out.getOrDefault(x[0],0)+1);
        }
        for(int i=1; i<=n; i++) {
            if((inc.containsKey(i) && inc.get(i)==n-1) && (!out.containsKey(i)))
                return i;
        }
        return -1;
    }
}