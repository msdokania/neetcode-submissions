class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        n = len(intervals)
        intervals.sort()
        prevend = intervals[0][1]
        count = 0
        for i in range(1,n):
            x = intervals[i]
            if x[0]>=prevend:
                prevend = x[1]
            else:
                count += 1
                prevend = min(x[1], prevend)
        return count

