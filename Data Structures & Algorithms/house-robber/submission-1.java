class Solution {
    public int rob(int[] nums) {
        int rob = nums[0];
        int notrob = 0;
        for(int i=1; i<nums.length; i++) {
            int x = notrob + nums[i];
            int y = Math.max(rob, notrob);
            rob = x;
            notrob = y;
        }
        return Math.max(rob, notrob);
    }
}
