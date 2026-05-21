class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        bucket = [[] for i in range(n+1)]
        count = {}
        for num in nums:
            count[num] = 1 + count.get(num, 0)
        for num in count.keys():
            bucket[count[num]].append(num)
        ans = []
        for i in range(n, 0, -1):
            for num in bucket[i]:
                ans.append(num)
                if len(ans)==k:
                    return ans
        return ans
