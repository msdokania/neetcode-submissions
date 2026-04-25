class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]!=val) {
                swap(nums, i, k);
                k++;
            }
        }
        return k;
    }
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}