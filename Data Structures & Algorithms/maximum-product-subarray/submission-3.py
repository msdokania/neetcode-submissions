class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        currmax = nums[0]
        currmin = nums[0]
        ans = nums[0]
        for i in range(1,len(nums)):
            tmp = currmax*nums[i]
            currmax = max(nums[i], currmax*nums[i], currmin*nums[i])
            currmin = min(nums[i], tmp, currmin*nums[i])
            ans = max(ans,currmax)
        return ans

# max = -3 (max till now / min till now * curr)
# min = -24 (min of num or max * num)
# ans = 8

# -24, -3, -24