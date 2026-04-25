class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int curr = nums[0];
        for(int i=1; i<nums.length; i++) {
            if(curr+nums[i] > nums[i]) {
                curr += nums[i];
            }
            else {
                curr = nums[i];
            }
            ans = Math.max(ans, curr);
        }
        return ans;
    }
}
