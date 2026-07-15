class Solution:
    def mostBooked(self, n: int, meetings: List[List[int]]) -> int:
        avrooms = []
        for i in range(n):
            heapq.heappush(avrooms, i)
        meetings.sort()
        live = [] #(end, room)
        ans = [0] * n
        for m in meetings:
            while live and live[0][0]<=m[0]:
                _,r = heapq.heappop(live)
                heapq.heappush(avrooms, r)
            endtime = m[1]
            if not avrooms:
                e,r = heapq.heappop(live)
                endtime = e + (m[1]-m[0])
                heapq.heappush(avrooms, r)
                
            room = heapq.heappop(avrooms)
            heapq.heappush(live, (endtime,room))
            ans[room] += 1
        
        maxmeeting = max(ans)
        for i in range(n):
            if ans[i]==maxmeeting:
                return i
        return -1


