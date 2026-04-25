class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[src] = 0;
        for(int i=0; i<=k; i++) {
            int[] tmpans = Arrays.copyOf(ans, n);
            for(int[] flight : flights) {
                int s=flight[0], d=flight[1], p=flight[2];
                if(ans[s]==Integer.MAX_VALUE)
                    continue;
                int x = ans[s]+p;
                if(x<tmpans[d]) {
                    tmpans[d] = x;
                }
            }
            ans = tmpans;
        }
        if(ans[dst]==Integer.MAX_VALUE)
            return -1;
        return ans[dst];
    }
}
