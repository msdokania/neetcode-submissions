class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        ans = 0
        bit = [0] * 32
        for num in nums:
            for i in range(32):
                bit[i] += ((num>>i) & 1)
        n = len(nums)
        for i in range(32):
            if bit[i] > n//2:
                if i==31:
                    ans -= (1<<i)
                else:
                    ans |= (1<<i)
        return ans


