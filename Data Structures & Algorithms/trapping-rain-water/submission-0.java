class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] rightMax = new int[n];
        int ans = 0;
        for(int i=n-2; i>=0; i--)
            rightMax[i] = Math.max(height[i+1], rightMax[i+1]);
        int leftMax = 0;
        int i=0;
        while(i<n && height[i]>=leftMax) {
            leftMax = height[i];
            i++;
        }
        while(i<n) {
            int vol = Math.min(rightMax[i],leftMax) - height[i];
            ans += Math.max(0,vol);
            leftMax = Math.max(leftMax, height[i]);
            i++;
        }
        return ans;
    }
}
