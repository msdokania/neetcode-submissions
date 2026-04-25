class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if(n==1) return 0;
        int ans = 0;
        int[] rightMax = new int[n];
        for(int i=n-2; i>=0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i+1]);
        }
        int maxLeft = height[0];
        for(int i=1; i<n; i++) {
            if(height[i] >= maxLeft || height[i] >= rightMax[i]) {
                maxLeft = height[i];
                continue;
            }
            ans += (Math.min(maxLeft, rightMax[i]) - height[i]); 
        }
        return ans;
    }
}
