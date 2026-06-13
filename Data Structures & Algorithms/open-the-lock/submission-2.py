class Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        stop = set(deadends)
        if target == "0000":
            return 0
        if "0000" in stop:
            return -1
        q = deque()
        q.append("0000")
        stop.add("0000")
        turns = 0

        def getNext(s: str) -> List[str]:
            ret = []
            for i,c in enumerate(s):
                nxt_no = str((int(c) + 1 + 10) % 10)
                ret.append(s[:i] + nxt_no + s[i+1:])
                prev_no = str((int(c) - 1 + 10) % 10)
                ret.append(s[:i] + prev_no + s[i+1:])
            return ret

        while q:
            siz = len(q)
            while siz>0:
                curr = q.popleft()
                if curr==target:
                    return turns
                for nxt in getNext(curr):
                    if nxt in stop:
                        continue
                    stop.add(nxt)
                    q.append(nxt)
                siz -= 1
            turns += 1
        return -1
            
            