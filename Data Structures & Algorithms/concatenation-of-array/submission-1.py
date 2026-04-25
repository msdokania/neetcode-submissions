class Solution:
    def getConcatenation(self, nums: List[int]) -> List[int]:
        newnums = []
        for i in range(len(nums)):
            newnums.append(nums[i])
        for i in range(len(nums)):
            newnums.append(nums[i])
        return newnums
        