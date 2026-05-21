class Solution:

    def encode(self, strs: List[str]) -> str:
        ans = ""
        for s in strs:
            ans = ans + str(len(s)) + '#' + s
        return ans

    def decode(self, s: str) -> List[str]:
        i = 0
        ans = []
        while i<len(s):
            j=i
            while s[j] != '#':
                j += 1
            num = int(s[i:j])
            j += 1
            ans.append(s[j : j+num])
            i = j+num
        return ans
