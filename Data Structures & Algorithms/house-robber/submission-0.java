class Solution {
    public int rob(int[] nums) {
        int[] rob_notrob = new int[2];
        rob_notrob[0] = nums[0];
        rob_notrob[1] = 0;
        for(int i=1; i<nums.length; i++) {
            int a = rob_notrob[1]+nums[i];
            int b = Math.max(rob_notrob[0], rob_notrob[1]);
            rob_notrob[0] = a;
            rob_notrob[1] = b;
        }
        return Math.max(rob_notrob[0], rob_notrob[1]);
    }
}

// 1,0
// 1,1
// 4,1
// 4,4