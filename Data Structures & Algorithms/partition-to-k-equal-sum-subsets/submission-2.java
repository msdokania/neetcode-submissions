class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        for(int x : nums)
            sum += x;
        if(sum%k != 0) return false;
        sum /= k;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
        boolean[] used = new boolean[n];
        return helper(nums, k, 0, sum, used);
    }
    public boolean helper(int[] nums, int k, int curr, int sum, boolean[] used) {
        if(k==0)
            return true;
        if(curr==sum) {
            return helper(nums, k-1, 0, sum, used);
        }
        for(int i=0; i<nums.length; i++) {
            if(used[i])
                continue;
            if(curr+nums[i]>sum) break;
            used[i] = true;
            if(helper(nums, k, curr + nums[i], sum, used))
                return true;
            used[i] = false;
        }
        return false;
    }
}