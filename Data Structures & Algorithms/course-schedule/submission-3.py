class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        n = len(prerequisites)
        indegree = [0] * numCourses
        adj = [[] for _ in range(numCourses)]
        for a,b in prerequisites:
            adj[b].append(a)
            indegree[a] += 1
        q = deque()
        for i in range(numCourses):
            if indegree[i]==0:
                q.append(i)
        taken = 0
        while q:
            curr = q.popleft()
            taken += 1
            for nxt in adj[curr]:
                indegree[nxt] -= 1
                if indegree[nxt]==0:
                    q.append(nxt)
            if taken==numCourses: 
                return True
        return False

