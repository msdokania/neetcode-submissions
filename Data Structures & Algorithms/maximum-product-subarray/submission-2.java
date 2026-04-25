class Solution {
    public int maxProduct(int[] nums) {
        int maxtillnow = nums[0];
        int mintillnow = nums[0];
        int ans = nums[0];
        for(int i=1; i<nums.length; i++) {
            int x = Math.max(nums[i], Math.max(nums[i]*maxtillnow, nums[i]*mintillnow));
            int y = Math.min(nums[i], Math.min(nums[i]*maxtillnow, nums[i]*mintillnow));
            maxtillnow = x;
            mintillnow = y;
            ans = Math.max(ans, maxtillnow);
        }
        return ans;
    }
}
