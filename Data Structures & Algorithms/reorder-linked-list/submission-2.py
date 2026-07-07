# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        first, sec = head,head
        while sec and sec.next:
            first = first.next
            sec = sec.next.next
        sec = first.next
        first.next = None

        def reverse(node: Optional[ListNode]) -> ListNode:
            if not node:
                return node
            prev = None
            while node:
                nxt = node.next
                node.next = prev
                prev = node
                node = nxt
            return prev

        sec = reverse(sec)
        first = head
        while sec and first:
            tmp = first.next
            first.next = sec
            sec = sec.next
            first.next.next = tmp
            first = tmp
