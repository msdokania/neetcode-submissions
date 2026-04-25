class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        def insertion(nums: List[int]):
            n = len(nums)
            for i in range(n-2,-1,-1):
                j = i+1
                num = nums[i]
                while j<n and num > nums[j]:
                    nums[j-1] = nums[j]
                    j += 1
                nums[j-1] = num
        # insertion(nums)

        def swap(nums: List[int], x: int, y: int):
            tmp = nums[x]
            nums[x] = nums[y]
            nums[y] = tmp
        def selection(nums: List[int]):
            for i in range(len(nums)):
                minnum, idx = nums[i],i
                for j in range(i+1, len(nums)):
                    if nums[j] <= minnum:
                        minnum = nums[j]
                        idx = j
                swap(nums, i, idx)
        selection(nums)
        # bubble(nums)
        # quick(nums)
        # merge(nums)
        
            
                        
                        

        return nums
