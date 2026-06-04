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
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode second = slow.next;
        slow.next = null;
        second = reverse(second);
        merge(head, second);
    }
    public void merge(ListNode n1, ListNode n2) {
        while(n2!=null) {
            ListNode tmp1 = n1.next;
            ListNode tmp2 = n2.next;
            n1.next = n2;
            n2.next = tmp1;
            n1 = tmp1;
            n2 = tmp2;
        }
    }
    public ListNode reverse(ListNode node) {
        if(node==null || node.next==null) return node;
        ListNode prev = null;
        while(node!=null) {
            ListNode tmp = node.next;
            node.next = prev;
            prev = node;
            node = tmp;
        }
        return prev;
    }
}
