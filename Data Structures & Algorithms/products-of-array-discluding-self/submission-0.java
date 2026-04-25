class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int leftProduct = 1;
        int zeros = 0;
        for(int i=0; i<n; i++) {
            if(nums[i]==0) zeros++;
        }
        if(zeros>1) return ans;
        ans[n-1] = 1;
        for(int i=n-2; i>=0; i--)
            ans[i] = ans[i+1] * nums[i+1];
        for(int i=0; i<n; i++) {
            ans[i] = leftProduct * ans[i];
            leftProduct *= nums[i];
        }
        return ans;
    }
}  
