class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        zeros = 0
        for num in nums:
            if num==0:
                zeros += 1
        ans = [0] * (n)
        if zeros > 1:
            return ans
        ans[0] = 1
        for i in range(1,n):
            ans[i] = ans[i-1] * nums[i-1]
        tmp = nums[n-1]
        for i in range(n-2, -1, -1):
            ans[i] *= tmp
            tmp *= nums[i]
        return ans