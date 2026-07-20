class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        n = len(nums)
        req = sum(nums)
        if req%2 != 0:
            return False
        req = req//2

        def traverse(i: int, curr: int) -> bool:
            if i >= n or curr>req:
                return False
            if curr==req:
                return True
            a = traverse(i+1, curr+nums[i])
            if a:
                return True
            return a or traverse(i+1, curr)

        return traverse(0,0)
        

# 1   -
# 12  1   -
# 123 x   12  13  1   -
# 124 x   12  134 x   13  14!!    1   -

# [1,0,3,4]
# 1   -
# 10  1   -
# 103    13  13  1   -
# 124 x   12  134 x   13  14!!    1   -