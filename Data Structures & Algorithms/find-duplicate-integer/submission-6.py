class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        for i in range(len(nums)):
            x = abs(nums[i])-1
            if nums[x]<0:
                return abs(nums[i])
            nums[x] = -nums[x]
        return -1