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
        if(head==null) return;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode list2 = slow.next;
        slow.next = null;
        list2 = rev(list2);
        merge(head, list2);
    }
    public ListNode rev(ListNode node) {
        ListNode prev = null;
        while(node!=null) {
            ListNode tmp = node.next;
            node.next = prev;
            prev = node;
            node = tmp;
        }
        return prev;
    }
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        dummy.next = l1;
        while(l2!=null) {
            ListNode tmp = l1.next;
            l1.next = l2;
            l1 = tmp;
            tmp = l2.next;
            l2.next = l1;
            l2 = tmp;
        }
        return dummy.next;
    }
}
