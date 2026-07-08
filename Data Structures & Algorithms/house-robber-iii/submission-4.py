# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rob(self, root: Optional[TreeNode]) -> int:
        def helper(node: Optional[TreeNode]) -> List[int]:
            if not node:
                return [0,0]
            a = helper(node.left)
            b = helper(node.right)
            r = node.val + a[1]+b[1]
            nr = max(a[0],a[1]) + max(b[0],b[1])
            return [r,nr]
            
        ans = helper(root)
        return max(ans[0],ans[1])

        [2,3], [3,0]