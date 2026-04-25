class ListNode {
    int val;
    ListNode next;
    public ListNode(int v) {
        val = v;
        next = null;
    }
}
class MyCircularQueue {
    ListNode root;
    int space;

    public MyCircularQueue(int k) {
        root = new ListNode(0);
        space = k;
    }
    
    public boolean enQueue(int value) {
        if(space==0) return false;
        ListNode curr = root;
        while(curr.next!=null)
            curr = curr.next;
        curr.next = new ListNode(value);
        space--;
        return true;
    }
    
    public boolean deQueue() {
        if(root.next==null) return false;
        ListNode curr = root.next;
        root.next = root.next.next;
        curr.next = null;
        space++;
        return true;
    }
    
    public int Front() {
        if(root.next==null) return -1;
        return root.next.val;
    }
    
    public int Rear() {
        if(root.next==null) return -1;
        ListNode curr = root.next;
        while(curr.next!=null)
            curr = curr.next;
        return curr.val;
    }
    
    public boolean isEmpty() {
        if(root.next==null) return true;
        return false;
    }
    
    public boolean isFull() {
        if(space==0) return true;
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */