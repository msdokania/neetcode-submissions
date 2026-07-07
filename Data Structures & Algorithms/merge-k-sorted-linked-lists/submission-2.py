# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:    
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        dummy = ListNode(0)
        prev = dummy
        q = []
        for i in range(len(lists)):
            if lists[i]:
                heapq.heappush(q, (lists[i].val, i, lists[i]))
        while q:
            v, i, tmp = heapq.heappop(q)
            newnode = ListNode(v)
            prev.next = newnode
            prev = newnode
            if tmp.next:
                heapq.heappush(q, (tmp.next.val, i, tmp.next))
        return dummy.next