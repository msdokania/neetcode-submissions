class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        exists = set(nums)
        return len(exists)!=len(nums)
        # for num in nums:
        #     if num in exists:
        #         return True
        #     exists.add(num)
        # return False
        