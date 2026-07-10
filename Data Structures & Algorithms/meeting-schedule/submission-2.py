"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    def canAttendMeetings(self, intervals: List[Interval]) -> bool:
        line = [0] * (1000001)
        for intr in intervals:
            line[intr.start] += 1
            line[intr.end] -= 1
        x = 0
        for i in line:
            x = x + i
            if x>1:
                return False
        return True