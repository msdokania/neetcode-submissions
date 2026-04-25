class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] rightmax = new int[n];
        for(int i=n-2; i>=0; i--) {
            rightmax[i] = Math.max(height[i+1], rightmax[i+1]);
        }
        int leftmax = 0;
        int i=0;
        while(i<n && height[i]>=leftmax) {
            leftmax = height[i];
            i++;
        }
        int ans = 0;
        while(i<n) {
            if(leftmax>height[i] && rightmax[i]>height[i]) {
                int ht = Math.min(leftmax, rightmax[i]);
                ans += ht-height[i];
            }
            leftmax = Math.max(leftmax, height[i]);
            i++;
        }
        return ans;
    }
}
