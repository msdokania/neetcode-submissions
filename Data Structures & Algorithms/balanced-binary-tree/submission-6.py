# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        def helper(node: Optional[TreeNode]) -> List[int]:
            if not node:
                return [1,0]
            l = helper(node.left)
            r = helper(node.right)
            if l[0]==0 or r[0]==0 or abs(l[1]-r[1])>1:
                return [0,0]
            return [1, 1+max(l[1],r[1])]

        ans = helper(root)
        return True if ans[0]==1 else False