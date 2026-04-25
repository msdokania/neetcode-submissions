class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        count = {}
        bucket = [[] for _ in range(n+1)]
        for num in nums:
            count[num] = count.get(num,0) + 1
        for key, val in count.items():
            bucket[val].append(key)
        ans = []
        for i in range(len(bucket)-1, 0, -1):
            for x in bucket[i]:
                ans.append(x)
                if len(ans) == k:
                    return ans
        return ans

