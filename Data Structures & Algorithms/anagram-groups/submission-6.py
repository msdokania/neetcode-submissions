class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        mp = defaultdict(list)
        def getHash(s : str) -> str:
            count = [0] * 26
            for i in range(len(s)):
                count[ord(s[i]) - ord('a')] += 1
            return tuple(count)
        for i in range(len(strs)):
            mp[getHash(strs[i])].append(strs[i])
        return list(mp.values())