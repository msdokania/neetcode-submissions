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
        int k = lists.length;
        Queue<ListNode> pq = new PriorityQueue<>((a,b)->(a.val-b.val));
        for(ListNode l : lists)
            pq.offer(l);
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(!pq.isEmpty()) {
            ListNode tmp = pq.poll();
            if(tmp.next!=null) {
                pq.offer(tmp.next);
                tmp.next = null;
            }
            curr.next = tmp;
            curr = tmp;
        }
        return dummy.next;
    }
}
