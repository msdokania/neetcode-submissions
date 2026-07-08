# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        idx = 0
        ans = -1
        def traverse(node: Optional[TreeNode]):
            nonlocal idx, ans
            if not node or ans!=-1:
                return
            traverse(node.left)
            idx += 1
            if idx==k:
                ans = node.val
                return
            traverse(node.right)
        traverse(root)
        return ans