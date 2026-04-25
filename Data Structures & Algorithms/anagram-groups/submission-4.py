class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        map = defaultdict(list)
        for s in strs:
            sortedstr = ''.join(sorted(s))
            map[sortedstr].append(s)
        return list(map.values())
        