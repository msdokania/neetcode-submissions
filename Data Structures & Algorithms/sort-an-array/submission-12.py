import random

class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        def insertion():
            n = len(nums)
            for i in range(n-2,-1,-1):
                j = i+1
                num = nums[i]
                while j<n and num > nums[j]:
                    nums[j-1] = nums[j]
                    j += 1
                nums[j-1] = num
        # insertion()

        def selection():
            for i in range(len(nums)):
                minnum, idx = nums[i],i
                for j in range(i+1, len(nums)):
                    if nums[j] <= minnum:
                        minnum = nums[j]
                        idx = j
                nums[i], nums[idx] = nums[idx], nums[i]
        # selection()

        def bubble():
            n = len(nums)
            for i in range(n):
                swaps = 0
                for j in range(0,n-i-1):
                    if nums[j] > nums[j+1]:
                        nums[j+1], nums[j] = nums[j], nums[j+1]
                        swaps += 1
                if swaps==0:
                    break
        # bubble()

        def partition(l: int, r:int) -> int:
            pividx = random.randint(l,r)
            nums[pividx], nums[r] = nums[r], nums[pividx]
            piv = nums[r]
            i = l
            j = i
            while j<r:
                if nums[j] <= piv:
                    nums[i], nums[j] = nums[j], nums[i]
                    i += 1
                j += 1
            nums[i], nums[r] = nums[r], nums[i]
            return i

        def quick(l: int, r:int):
            if l>=r:
                return
            p = partition(l,r)
            quick(l,p-1)
            quick(p+1,r)

        quick(0, len(nums)-1)
        # merge(nums)
        
            
                        
                        

        return nums
