class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currmax=nums[0], currmin=nums[0];
        int max=nums[0], min=nums[0];
        int total = nums[0];
        for(int i=1; i<nums.length; i++) {
            total += nums[i];
            currmax = Math.max(nums[i], currmax+nums[i]);
            currmin = Math.min(nums[i], currmin+nums[i]);
            max = Math.max(max, currmax);
            min = Math.min(min, currmin);
        }
        return max>0 ? Math.max(max, total-min) : max;
    }
}