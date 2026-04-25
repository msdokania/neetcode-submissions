class Solution {
    int ans;
    public int subsetXORSum(int[] nums) {
        ans = 0;
        traverse(nums,0,new ArrayList<>());
        return ans;
    }
    public void traverse(int[] nums, int i, List<Integer> curr) {
        int ret = 0;
        for(int x : curr) {
            ret ^= x;
        }
        ans += ret;
        for(int j=i; j<nums.length; j++) {
            curr.add(nums[j]);
            traverse(nums, j+1, curr);
            curr.removeLast();
        }
    }
}