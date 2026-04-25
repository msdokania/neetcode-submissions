class ListNode {
    int val;
    ListNode next;
    ListNode(int v) {
        val = v;
    }
}
class MyHashSet {
    ListNode[] list;

    public MyHashSet() {
        list = new ListNode[10000];
        for(int i=0; i<10000; i++)
            list[i] = new ListNode(0);
    }
    
    public void add(int key) {
        int x = key % 10000;
        ListNode curr = list[x];
        while(curr.next != null) {
            if(curr.next.val == key) return;
            curr = curr.next;
        }
        ListNode n = new ListNode(key);
        curr.next = n;
    }
    
    public void remove(int key) {
        int x = key % 10000;
        ListNode curr = list[x];
        while(curr.next != null) {
            if(curr.next.val == key) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }
    
    public boolean contains(int key) {
        int x = key % 10000;
        ListNode curr = list[x];
        while(curr.next != null) {
            if(curr.next.val == key) return true;
            curr = curr.next;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */