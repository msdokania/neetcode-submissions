"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    def minMeetingRooms(self, intervals: List[Interval]) -> int:
        line = [0] * 1000001
        for intr in intervals:
            line[intr.start] += 1
            line[intr.end] -= 1
        ans = 0
        curr = 0
        for i in range(1000001):
            curr = curr + line[i]
            ans = max(ans, curr)
        return ans