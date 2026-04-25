class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int one=-1, two=n;
        int i=0;
        while(i<two) {
            if(nums[i]==0) {
                one++;
                nums[one] = 0;
                if(i!=one) nums[i] = 1;
                i++;
            }
            else if(nums[i]==2) {
                two--;
                nums[i] = nums[two];
                nums[two] = 2;
            }
            else {
                i++;
            }
        }
    }
}