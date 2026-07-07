# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        curr = head
        total = 0
        while curr:
            curr = curr.next
            total += 1
        k = total-n
        if k==0:
            return head.next
        curr = head
        while k>1:
            curr = curr.next
            k = k-1
        curr.next = curr.next.next
        return head