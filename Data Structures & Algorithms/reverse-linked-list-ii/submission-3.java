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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode prev = dummy;
        for(int i=0; i<left-1; i++) {
            prev = cur;
            cur = cur.next;
        }

        ListNode tail = cur;
        ListNode tmpprev = null;
        for(int i=0; i<right-left+1; i++) {
            ListNode tmpnext = cur.next;
            cur.next = tmpprev;
            tmpprev = cur;
            cur = tmpnext;
        }
        prev.next = tmpprev;
        tail.next = cur;
        return dummy.next;
    }
}