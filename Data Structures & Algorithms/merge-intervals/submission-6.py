class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        mp = defaultdict(int)
        for intr in intervals:
            mp[intr[0]] += 1
            mp[intr[1]] -= 1
        ans = []
        count = 0
        start = 0
        for k in sorted(mp):
            if count==0:
                start = k
            count += mp[k]
            if count==0:
                ans.append([start,k])
        return ans