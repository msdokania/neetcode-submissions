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
        ListNode curr = head;
        ListNode torev = head.next;
        curr.next = null;
        while(torev!=null) {
            ListNode tmp = torev.next;
            torev.next = curr;
            curr = torev;
            torev = tmp;
        }
        return curr;
    }
}
