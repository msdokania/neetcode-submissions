# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        ans = 0
        def good(node: TreeNode, maxtillnow: int):
            nonlocal ans
            if not node:
                return
            if maxtillnow<=node.val:
                ans += 1
            good(node.left, max(maxtillnow,node.val))
            good(node.right, max(maxtillnow, node.val))

        good(root, float("-inf"))
        return ans