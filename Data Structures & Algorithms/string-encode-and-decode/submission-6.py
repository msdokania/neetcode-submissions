class Solution:

    def encode(self, strs: List[str]) -> str:
        parts = []
        for s in strs:
            tmp = str(len(s)) + '#' + s
            parts.append(tmp)
        return "".join(parts)

    def decode(self, s: str) -> List[str]:
        i = 0
        ans = []
        while i<len(s):
            j = i
            while s[j] != '#':
                j += 1
            x = int(s[i:j])
            j += 1
            ans.append(s[j:j+x])
            i = j+x
        return ans
