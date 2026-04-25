class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l=0, r=n-1;
        int left=height[0], right=height[n-1];
        int ans = 0;
        while(l<r) {
            if(left<=right) {
                l++;
                left = Math.max(left, height[l]);
                ans += left-height[l];
            }
            else {
                r--;
                right = Math.max(right, height[r]);
                ans += right-height[r];
            }
        }
        return ans;
    }
}
