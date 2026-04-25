/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> hm = new HashMap<>();
        if(head==null) return null;
        Node newHead = new Node(head.val);
        hm.put(null, null);
        hm.put(head, newHead);
        while(head!=null) {
            if(!hm.containsKey(head)) {
                hm.put(head, new Node(head.val));
            }
            hm.get(head).val = head.val;
            if(!hm.containsKey(head.next)) {
                hm.put(head.next, new Node(0));
            }
            hm.get(head).next = hm.get(head.next);
            if(!hm.containsKey(head.random)) {
                hm.put(head.random, new Node(0));
            }
            hm.get(head).random = hm.get(head.random);
            head = head.next;
        }
        return newHead;
    }
}
