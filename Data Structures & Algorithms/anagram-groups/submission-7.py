class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        ans = defaultdict(list)
        for curr in strs:
            s = ''.join(sorted(curr))
            ans[s].append(curr)
        return list(ans.values())