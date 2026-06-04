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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode curr = head;
        while(curr!=null) {
            len++;
            curr = curr.next;
        }
        if(len==n) return head.next;
        curr = head;
        len = len-n;
        while(len > 1) {
            curr = curr.next;
            len--;
        }
        curr.next = curr.next.next;
        return head;
    }
}
