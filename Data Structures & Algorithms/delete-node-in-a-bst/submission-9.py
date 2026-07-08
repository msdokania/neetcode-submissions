# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def deleteNode(self, root: Optional[TreeNode], key: int) -> Optional[TreeNode]:
        if not root:
            return None
        prev = None
        curr = root
        while curr and curr.val!=key:
            prev = curr
            if key<curr.val:
                curr = curr.left
            elif key>curr.val:
                curr = curr.right
        if not curr:
            return root

        if not curr.left or not curr.right:
            child = curr.left if curr.left else curr.right
            if not prev:
                return child
            if prev.left==curr:
                prev.left = child
            else:
                prev.right = child
            return root

        nxt = curr.right
        par = None
        while nxt.left:
            par = nxt
            nxt = nxt.left
        curr.val = nxt.val
        if not par:
            curr.right = nxt.right
        else:
            par.left = nxt.right
        return root



