class Solution {
    public boolean canJump(int[] nums) {
        int currmax = 0;
        if(nums.length==1) return true;
        for(int i=0; i<nums.length; i++) {
            if(i>currmax) return false;
            currmax = Math.max(currmax, i+nums[i]);
            if(currmax>=nums.length-1)
                return true;
        }
        return currmax>=nums.length-1;
    }
}
