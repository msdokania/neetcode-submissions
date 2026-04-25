class Solution {
    int ans;
    public int subsetXORSum(int[] nums) {
        ans = 0;
        subsets(nums, 0, 0);
        return ans;
    }
    public void subsets(int[] nums, int i, int curr) {
        if(i>=nums.length) {
            ans += curr;
            return;
        }
        subsets(nums, i+1, curr^nums[i]);
        subsets(nums, i+1, curr);
    }
}