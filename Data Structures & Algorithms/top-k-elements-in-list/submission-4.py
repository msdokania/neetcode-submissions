class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count = {}
        for num in nums:
            count[num] = count.get(num,0) + 1
        pq = []
        for key,v in count.items():
            heapq.heappush(pq, (v,key))
            if len(pq) > k:
                heapq.heappop(pq)
            
        ans = []
        for i in range(k):
            ans.append(heapq.heappop(pq)[1])
        return ans