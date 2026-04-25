class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        a1, a2 = -1,-1
        c1, c2 = 0,0
        for num in nums:
            if num==a1:
                c1 += 1
            elif num==a2:
                c2 += 1
            elif c1==0:
                c1 = 1
                a1 = num
            elif c2==0:
                c2 = 1
                a2 = num
            else:
                c1 -= 1
                c2 -= 1
        ans = []
        x = len(nums)//3
        c1 = c2 = 0
        for num in nums:
            if num==a1:
                c1 += 1
            elif num==a2:
                c2 += 1
        if a1 != -1 and c1 > x:
            ans.append(a1)
        if a2 != -1 and c2 > x:
            ans.append(a2)
        return ans


# def majorityElement(self, nums: List[int]) -> List[int]:
#         mp = Counter(nums)
#         ans = []
#         # for num in nums:
#         #     mp[num] = mp.get(num,0) + 1
#         x = len(nums)//3
#         for k,v in mp.items():
#             if v>x:
#                 ans.append(k)
#         return ans