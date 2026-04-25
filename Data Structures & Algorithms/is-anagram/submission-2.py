class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        # return sorted(s) == sorted(t)
        freq = [0] * 26
        for i in range(len(s)):
            freq[ord(s[i]) - ord('a')] += 1
        for i in range(len(t)):
            freq[ord(t[i]) - ord('a')] -= 1
        for i in range(26):
            if freq[i] != 0:
                return False
        return True
        