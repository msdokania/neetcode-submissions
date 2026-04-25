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
        ListNode prev = dummy;
        for(int i=0; i<left-1; i++)
            prev = prev.next;
        ListNode liststart = prev.next;
        prev.next = null;
        ListNode listend = liststart;
        for(int i=left; i<right; i++)
            listend = listend.next;
        ListNode next = listend.next;
        listend.next = null;
        prev.next = reverse(liststart);
        liststart.next = next;
        return dummy.next;
    }
    public ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;
        while(curr!=null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }
}