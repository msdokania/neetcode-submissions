class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int zeros = 0;
        for(int x : nums) {
            if(x==0) zeros++;
        }
        if(zeros>1) return ans;
        ans[0] = 1;
        for(int i=1; i<nums.length; i++) {
            ans[i] = ans[i-1] * nums[i-1];
        }
        int tmp = 1;
        for(int i=nums.length-1; i>=0; i--) {
            ans[i] *= tmp;
            tmp *= nums[i];
        }
        return ans;
    }
}  
