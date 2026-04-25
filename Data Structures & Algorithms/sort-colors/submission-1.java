class Solution {
    public void sortColors(int[] nums) {
        int l=-1, r=nums.length-1, i=0;
        while(i<=r) {
            if(nums[i] == 0) {
                swap(nums, l+1, i);
                l++;
                i++;
            }
            else if(nums[i] == 2) {
                swap(nums, i, r);
                r--;
            }
            else
                i++;
        }
    }

    public void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
}