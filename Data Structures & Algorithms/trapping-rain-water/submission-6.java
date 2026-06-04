class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] rightMax = new int[n];
        for(int i=n-2; i>=0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i+1]);
        }
        int ans = 0;
        int left = 0;
        for(int i=0; i<n; i++) {
            int limit = Math.min(left, rightMax[i]);
            int tmp = Math.max(0, limit-height[i]);
            ans += tmp;
            left = Math.max(left, height[i]);
        }
        return ans;
    }
}
