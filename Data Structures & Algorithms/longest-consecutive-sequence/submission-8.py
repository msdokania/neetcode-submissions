class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        s = set(nums)
        maxlen = 0
        for num in s:
            if num-1 not in s:
                len = 1
                x = num+1
                while x in s:
                    len += 1
                    x += 1
                maxlen = max(maxlen,len)
        return maxlen
