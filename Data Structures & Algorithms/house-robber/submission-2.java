class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int x=nums[0], y=Math.max(nums[0], nums[1]);
        for(int i=2; i<nums.length; i++) {
            int tmp = Math.max(nums[i]+x, Math.max(x,y));
            x = y;
            y = tmp;
        }
        return y;
    }
}
