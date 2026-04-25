class Solution {
    public int climbStairs(int n) {
        if(n==1) return 1;
        int prevprev = 1;
        int prev = 2;
        for(int i=3; i<=n; i++) {
            int x = prev + prevprev;
            prevprev = prev;
            prev = x;
        }
        return prev;
    }
}
