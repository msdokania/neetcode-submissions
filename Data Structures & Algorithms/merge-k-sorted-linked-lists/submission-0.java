/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(n==0) return null;
        Queue<ListNode> pq = new PriorityQueue<>(
            (a,b) -> (a.val-b.val)
        );
        for(ListNode lst : lists) {
            if(lst!=null) pq.offer(lst);
        }
        if(pq.isEmpty()) return null;
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        while(!pq.isEmpty()) {
            ListNode tmp = pq.poll();
            prev.next = tmp;
            prev = tmp;
            if(tmp.next!=null)
                pq.offer(tmp.next);
        }
        return dummy.next;
    }
}
