"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        mp = defaultdict()

        def clone(n):
            if not n:
                return None
            if n in mp:
                return mp[n]
            copy = Node(n.val)
            mp[n] = copy
            for nei in n.neighbors:
                copy.neighbors.append(clone(nei))
            return copy

        return clone(node)

        