class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        smap, tmap = {}, {}
        for i in range(len(s)):
            smap[s[i]] = 1 + smap.get(s[i], 0)
            tmap[t[i]] = 1 + tmap.get(t[i], 0)
        return smap==tmap



# def isAnagram(self, s: str, t: str) -> bool:
#         # return sorted(s) == sorted(t)
#         freq = [0] * 26
#         for i in range(len(s)):
#             freq[ord(s[i]) - ord('a')] += 1
#         for i in range(len(t)):
#             freq[ord(t[i]) - ord('a')] -= 1
#         for i in range(26):
#             if freq[i] != 0:
#                 return False
#         return True
        