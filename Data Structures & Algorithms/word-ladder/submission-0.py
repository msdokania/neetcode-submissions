class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        wordset = set(wordList)
        q = deque()
        q.append(beginWord)
        ans = 0
        while q:
            ln = len(q)
            ans += 1
            while ln>0:
                curr = q.popleft()
                if curr==endWord:
                    return ans
                for i in range(len(curr)):
                    for c in range(ord('a'), ord('z')+1):
                        if chr(c)==curr[i]:
                            continue
                        newcurr = curr[:i]+chr(c)+curr[i+1:]
                        if newcurr in wordset:
                            q.append(newcurr)
                            wordset.remove(newcurr)
                ln -= 1
        return 0
            