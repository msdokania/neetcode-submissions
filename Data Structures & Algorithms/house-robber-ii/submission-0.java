class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);
        return Math.max(helper(nums,0,nums.length-2), helper(nums,1,nums.length-1));
    }

    public int helper(int[] nums, int l, int r) {
        int rob1=0, rob2=nums[l];
        for(int i=l+1; i<=r; i++) {
            int x = Math.max(nums[i]+rob1, rob2);
            rob1 = rob2;
            rob2 = x;
        }
        return rob2;
    }
}
