class Solution:
    def isAlienSorted(self, words: List[str], order: str) -> bool:
        mp = {}
        for i in range(len(order)):
            mp[order[i]] = i
        for i in range(len(words)-1):
            first, sec = words[i], words[i+1]
            l = min(len(first), len(sec))
            j = 0
            while j<l and first[j]==sec[j]:
                j += 1
            if j>=len(first):
                continue
            if j>=len(sec) or mp.get(first[j])>mp.get(sec[j]):
                return False
        return True
