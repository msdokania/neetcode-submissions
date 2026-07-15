class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        ans = []
        if len(intervals)==0:
            return [newInterval]
        for i in range(len(intervals)):
            intr = intervals[i]
            if newInterval[1]<intr[0]:
                ans.append(newInterval)
                return ans + intervals[i:]
            if newInterval[0]<=intr[1]:
                newInterval[0] = min(newInterval[0],intr[0])
                newInterval[1] = max(newInterval[1],intr[1])
            else:
                ans.append(intr)
        ans.append(newInterval)
        return ans