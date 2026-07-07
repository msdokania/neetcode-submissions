"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        mp = {}
        def copy(node: 'Optional[Node]'):
            if not node:
                return None
            if node in mp:
                return mp.get(node)
            newnode = Node(node.val)
            mp[node] = newnode
            newnode.next = copy(node.next)
            newnode.random = copy(node.random)
            return newnode

        return copy(head)