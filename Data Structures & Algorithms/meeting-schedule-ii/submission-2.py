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
        mp = defaultdict(int)
        for intr in intervals:
            mp[intr.start] += 1
            mp[intr.end] -= 1
        ans = 0
        curr = 0
        for i in sorted(mp.keys()):
            curr = curr + mp[i]
            ans = max(ans, curr)
        return ans