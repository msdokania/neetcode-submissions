class Solution:
    def mostBooked(self, n: int, meetings: List[List[int]]) -> int:
        avrooms = []
        roomcount = [0]*n
        ongoing = []
        for i in range(n):
            heapq.heappush(avrooms, i)
        meetings.sort()
        for curr in meetings:
            starttime = curr[0]
            while ongoing and ongoing[0][0]<=starttime:
                _, freed = heapq.heappop(ongoing)
                heapq.heappush(avrooms, freed)

            if len(avrooms)>0:
                r = heapq.heappop(avrooms)
                roomcount[r] += 1
                heapq.heappush(ongoing, (curr[1],r))
            else:
                last, rm = heapq.heappop(ongoing)
                roomcount[rm] += 1
                newend = last + (curr[1]-curr[0])
                heapq.heappush(ongoing, (newend,rm))

        maxmeetings = max(roomcount)
        for i in range(n):
            if roomcount[i]==maxmeetings:
                return i
        return -1




