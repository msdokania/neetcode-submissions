class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n==1) return 0;
        int ans = 1;
        int l=0, r=0;
        while(r<n) {
            int nr = r;
            for(int i=l; i<=r; i++) {
                nr = Math.max(nr, nums[i]+i);
                if(nr>=n-1) return ans;
            }
            ans++;
            l=r+1;
            r = nr;
        }
        return ans;
    }
}
