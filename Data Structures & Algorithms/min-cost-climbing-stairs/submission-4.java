class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int x=cost[0], y=cost[1];
        for(int i=2; i<cost.length; i++) {
            int tmp = cost[i]+Math.min(x,y);
            x = y;
            y = tmp;
        }
        return Math.min(x,y);
    }
}
