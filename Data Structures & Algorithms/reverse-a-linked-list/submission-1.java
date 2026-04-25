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
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        return rev(head, null);
    }
    public ListNode rev(ListNode head, ListNode prev) {
        if(head==null) return prev;
        ListNode tmp = head.next;
        head.next = prev;
        prev = head;
        head = tmp;
        return rev(head, prev);
    }
}
