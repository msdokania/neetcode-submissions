class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int x : nums)
            sum += x;
        if(sum%k != 0) return false;
        sum /= k;
        Arrays.sort(nums);
        if(nums[0] > sum) return false;
        return helper(nums, 0, sum, new int[k]);
    }
    public boolean helper(int[] nums, int i, int sum, int[] curr) {
        if(i==nums.length)
            return true;
        for(int j=0; j<curr.length; j++) {
            if(curr[j]==sum || (j>0 && curr[j]==curr[j-1]))
                continue;
            if(curr[j]+nums[i]>sum)
                continue;
            curr[j] += nums[i];
            if(helper(nums, i+1, sum, curr))
                return true;
            curr[j] -= nums[i];
        }
        return false;
    }
}