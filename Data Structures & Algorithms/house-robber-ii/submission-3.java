class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int n = nums.length;
        return Math.max(helper(nums,0,n-2), helper(nums,1,n-1));
    }
    public int helper(int[] nums, int l, int r) {
        if (l == r) return nums[l];
        int x = nums[l];
        int y = Math.max(nums[l+1], nums[l]);
        for(int i=l+2; i<=r; i++) {
            int tmp = Math.max(nums[i]+x, y);
            x = y;
            y = tmp;
        }
        return y;
    }
}
