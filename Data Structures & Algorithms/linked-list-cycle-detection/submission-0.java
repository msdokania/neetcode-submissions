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
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int flag = 0;
        while(fast !=null && fast.next != null) {
            if(slow==fast && flag==1) return true;
            flag = 1;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
