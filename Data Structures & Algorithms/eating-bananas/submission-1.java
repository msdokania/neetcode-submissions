class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        if(n>h) return -1;
        Arrays.sort(piles);
        int l=1, r=piles[n-1];
        int ans = piles[n-1];
        while(l<=r) {
            int mid = l + (r-l)/2;
            long time = 0;
            for(int i=0; i<n; i++) {
                time += Math.ceil((double)piles[i]/(double)mid);;
            }
            if(h<time) l = mid+1;
            else {
                ans = Math.min(ans, mid);
                r = mid-1;
            } 
        }
        return ans;
    }
}
