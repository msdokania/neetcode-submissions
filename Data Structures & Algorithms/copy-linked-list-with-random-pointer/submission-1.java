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
    Map<Node, Node> hm;
    public Node copyRandomList(Node head) {
        hm = new HashMap<>();
        return copy(head); 
    }
    public Node copy(Node head) {
        if(head==null) return null;
        if(hm.containsKey(head)) 
            return hm.get(head);
        Node newhead = new Node(head.val);
        hm.put(head, newhead);
        newhead.next = copy(head.next);
        newhead.random = copy(head.random);
        return newhead;
    }
}
