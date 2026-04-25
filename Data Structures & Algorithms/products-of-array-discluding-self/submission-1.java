class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int zerocount = 0;
        for(int x : nums) {
            if (x==0) zerocount++;
        }
        if(zerocount>1) return ans;
        ans[0] = 1;
        for(int i=1; i<n; i++) {
            ans[i] = ans[i-1]*nums[i-1];
        }
        int x = nums[n-1];
        for(int i=n-2; i>=0; i--) {
            ans[i] *= x;
            x *= nums[i];
        }
        return ans;
    }
}  

