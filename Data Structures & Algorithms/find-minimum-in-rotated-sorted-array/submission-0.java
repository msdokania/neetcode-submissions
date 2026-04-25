class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l=0, r=n-1;
        int ans = nums[0];
        while(l<=r) {
            int mid = l + (r-l)/2;
            if(nums[l] <= nums[r]) {
                ans = Math.min(ans, nums[l]);
                break;
            }
            ans = Math.min(ans, nums[mid]);
            if (nums[mid] >= nums[l]) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return ans;
    }
}


// [1,2,3,4,5,6] mid>l && mid<r -> min lies to left
// [3,4,5,6,1,2] mid>l && mid>r -> min lies to right
// [3,4,5,6,1,2] mid<l && mid<r -> min to left or =
// [4,5,6,1,2,3]