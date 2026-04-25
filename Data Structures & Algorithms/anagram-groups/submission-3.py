class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        map = {}
        for s in strs:
            sortedstr = ''.join(sorted(s))
            tmp = map.get(sortedstr, [])
            tmp.append(s)
            map[sortedstr] = tmp
        ans = []
        for k,v in map.items():
            ans.append(v)
        return ans
        