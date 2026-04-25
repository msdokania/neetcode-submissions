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
        if(head.next==null) return null;
        int x = 0;
        ListNode curr = head;
        while(curr!=null) {
            x++;
            curr = curr.next;
        }
        if(x==n) return head.next;
        x = x-n;
        curr = head;
        x--;
        while(x>0) {
            curr = curr.next;
            x--;
        }
        curr.next = curr.next.next;
        return head;
    }
}
