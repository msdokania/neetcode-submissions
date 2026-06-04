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
    Map<Node, Node> hm = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        if(hm.containsKey(head))
            return hm.get(head);
        Node copyhead = new Node(head.val);
        hm.put(head, copyhead);
        copyhead.next = copyRandomList(head.next);
        copyhead.random = copyRandomList(head.random);
        return copyhead;
    }
}
