class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        ans = []
        i = 0
        while i<len(intervals):
            intr = intervals[i]
            if newInterval[1]<intr[0]:
                break
            elif newInterval[0]>intr[1]:
                ans.append(intr)
                i += 1
            else:
                newInterval[0] = min(newInterval[0],intr[0])
                newInterval[1] = max(newInterval[1],intr[1])
                i += 1
        ans.append(newInterval)
        while i<len(intervals):
            ans.append(intervals[i])
            i += 1
        return ans 