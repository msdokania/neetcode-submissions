class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        currmax, currmin = nums[0], nums[0]
        ans = nums[0]
        for i in range(1,len(nums)):
            tmp = currmax
            currmax = max(nums[i], currmin*nums[i], currmax*nums[i])
            currmin = min(nums[i], currmin*nums[i], tmp*nums[i])
            ans = max(ans, currmax)
        return ans