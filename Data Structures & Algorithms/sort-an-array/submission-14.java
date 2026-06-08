class Solution {
    public int[] sortArray(int[] nums) {
        mergesort(nums,0,nums.length-1);
        return nums;
    }
    public void mergesort(int[] nums, int l, int r) {
        if(l>=r) return;
        int m = (l+r)/2;
        mergesort(nums,l,m);
        mergesort(nums,m+1,r);
        merge(nums,l,m,r);
    }
    public void merge(int[] nums, int l, int m, int r) {
        List<Integer> lst = new ArrayList<>();
        int i=l, j=m+1;
        while(i<=m && j<=r) {
            if(nums[i]<=nums[j]) {
                lst.add(nums[i]);
                i++;
            } else {
                lst.add(nums[j]);
                j++;
            }
        }
        while(i<=m) {
            lst.add(nums[i]);
            i++;
        }
        while(j<=r) {
            lst.add(nums[j]);
            j++;
        }
        for(i=l; i<=r; i++) {
            nums[i] = lst.get(i-l);
        }
    }
}