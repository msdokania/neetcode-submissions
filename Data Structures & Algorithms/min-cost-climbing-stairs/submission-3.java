class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int prevprev = cost[0];
        int prev = Math.min(prevprev+cost[1], cost[1]);
        for(int i=2; i<n; i++) {
            int x = Math.min(prev+cost[i], prevprev+cost[i]);
            prevprev = prev;
            prev = x;
        }
        return Math.min(prev, prevprev);
    }
}
