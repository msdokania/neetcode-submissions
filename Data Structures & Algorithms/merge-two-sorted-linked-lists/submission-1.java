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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        dummy.next = list1;
        ListNode prev1 = dummy;
        while(list1!=null || list2!=null) {
            if(list1==null) {
                prev1.next = list2;
                list2 = null;
            }
            else if(list2==null) {
                return dummy.next;
            }
            else if(list1.val <= list2.val) {
                prev1 = list1;
                list1 = list1.next;
            }
            else {
                ListNode tmp = list2.next;
                prev1.next = list2;
                list2.next = list1;
                prev1 = list2;
                list2 = tmp;
            }
        }
        return dummy.next;
    }
}