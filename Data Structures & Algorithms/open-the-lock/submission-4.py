class Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        stop = set(deadends)
        if "0000" in stop:
            return -1
        q = deque()
        q.append("0000")
        stop.add("0000")
        turns = 0

        def getNext(st: str) -> List[str]:
            ret = []
            for i in range(4):
                nxt = (int(st[i]) + 1)%10
                prev = int(st[i]) - 1
                if prev==-1:
                    prev = 9
                ret.append(st[0:i] + str(prev) + st[i+1:4])
                ret.append(st[0:i] + str(nxt) + st[i+1:4])
            return ret

        while q:
            ln = len(q)
            while ln>0:
                curr = q.popleft()
                if curr==target:
                    return turns
                for s in getNext(curr):
                    if s in stop:
                        continue
                    stop.add(s)
                    q.append(s)
                ln -= 1
            turns += 1
        return -1