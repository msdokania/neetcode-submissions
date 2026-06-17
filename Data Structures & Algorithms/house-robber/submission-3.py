class Solution:
    def rob(self, nums: List[int]) -> int:
        prev = nums[0]
        if len(nums)==1:
            return prev
        curr = max(nums[1], nums[0])
        for i in range(2, len(nums)):
            rob = nums[i]+prev
            dont = max(prev,curr)
            prev = curr
            curr = max(rob,dont)
        return curr