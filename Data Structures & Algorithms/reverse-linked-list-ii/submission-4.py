# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        if left==right:
            return head
        dummy = ListNode(0,head)
        prev = dummy
        start,end = prev,prev
        for _ in range(right-left):
            end = end.next
        for _ in range(left):
            prev = start
            start = start.next
            end = end.next
        prev.next = None
        tmp = end.next
        end.next = None
        end = start
        prevtostart = None
        while start:
            t = start.next
            start.next = prevtostart
            prevtostart = start
            start = t
        prev.next = prevtostart
        end.next = tmp
        return dummy.next
