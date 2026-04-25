class Solution {
    public int rob(int[] nums) {
        int robFirstMoney = nums[0] + helper(nums, 2, nums.length-2);
        int notRobFirstMoney = helper(nums, 1, nums.length-1);
        return Math.max(robFirstMoney, notRobFirstMoney);
    }

    public int helper(int[] nums, int l, int r) {
        if(r>=nums.length || l>r)
            return 0;
        int rob = nums[l];
        int notrob = 0;
        for(int i=l+1; i<=r; i++) {
            int x = nums[i] + notrob;
            int y = Math.max(rob, notrob);
            rob = x;
            notrob = y;
        }
        return Math.max(rob, notrob);
    }
}
