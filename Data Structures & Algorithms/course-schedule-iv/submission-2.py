class Solution:
    def checkIfPrerequisite(self, numCourses: int, prerequisites: List[List[int]], queries: List[List[int]]) -> List[bool]:
        adj = [[] for _ in range(numCourses)]
        ispre = [[-1] * numCourses for _ in range(numCourses)]
        ans = []
        for a,b in prerequisites:
            adj[a].append(b)
            ispre[a][b] = 1

        def dfs(curr: int, target: int) -> bool:
            if ispre[curr][target] != -1:
                return ispre[curr][target]==1
            if curr==target:
                return True
            for nxt in adj[curr]:
                if dfs(nxt,target):
                    ispre[curr][target] = 1
                    return True
            ispre[curr][target] = 0
            return False

        for query in queries:
            ans.append(dfs(query[0], query[1]))
        return ans


# 0: 
# 1: 0
# 2: 1
# 3: 2