class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return 1;
        Arrays.sort(nums);
        int ans = 1;
        int streak = 1;
        int i=1;
        while(i<nums.length) {
            if(nums[i]==nums[i-1]) {
                i++;
            }
            else if(nums[i]==nums[i-1]+1) {
                streak++;
                i++;
                ans = Math.max(ans, streak);
            }
            else {
                streak = 1;
                i++;
            }
        }
        return ans;
    }
}
