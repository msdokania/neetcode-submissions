class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        ans = defaultdict(list)
        for curr in strs:
            count = [0] * 26
            for c in curr:
                count[ord(c) - ord('a')] += 1
            ans[tuple(count)].append(curr)
        return list(ans.values())