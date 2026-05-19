class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        scount, tcount = {}, {}
        for i in range(len(s)):
            scount[s[i]] = 1+ scount.get(s[i], 0)
        for i in range(len(t)):
            tcount[t[i]] = 1+ tcount.get(t[i], 0)
        return scount == tcount