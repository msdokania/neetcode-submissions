class Solution {
    public int[] sortArray(int[] nums) {
        quicksort(nums, 0, nums.length-1);
        // mergesort(nums)
        return nums;
    }
    public void quicksort(int[] nums, int l, int r) {
        if(l>=r) return;
        int pivIdx = partition(nums, l, r);
        quicksort(nums,l,pivIdx-1);
        quicksort(nums,pivIdx+1,r);
    }
    public int partition(int[] nums, int l, int r) {
        int piv = nums[r];
        int i=l;
        for(int j=l; j<r; j++) {
            if(nums[j]<=piv) {
                swap(nums,i,j);
                i++;
            }
        }
        swap(nums,i,r);
        return i;
    }
    public void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
}