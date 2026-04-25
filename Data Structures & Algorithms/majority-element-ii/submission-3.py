class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        mp = Counter(nums)
        ans = []
        # for num in nums:
        #     mp[num] = mp.get(num,0) + 1
        x = len(nums)//3
        for k,v in mp.items():
            if v>x:
                ans.append(k)
        return ans