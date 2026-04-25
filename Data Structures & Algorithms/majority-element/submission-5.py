class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        count = defaultdict(int)
        ans = maxcount = 0
        for num in nums:
            count[num] += 1
            if count[num] > maxcount:
                maxcount = count[num]
                ans = num
        return ans