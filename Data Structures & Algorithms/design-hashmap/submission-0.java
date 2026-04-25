class ListNode {
    int key;
    int val;
    ListNode next;
    ListNode(int k, int v) {
        key = k;
        val = v;
    }
}
class MyHashMap {
    ListNode[] list;

    public MyHashMap() {
        list = new ListNode[10000];
        for(int i=0; i<10000; i++)
            list[i] = new ListNode(0,0);
    }
    
    public void put(int key, int value) {
        ListNode curr = list[key%10000];
        while(curr.next!=null) {
            if(curr.next.key == key) {
                curr.next.val = value;
                return;
            }
            curr = curr.next;
        }
        curr.next = new ListNode(key, value);
    }
    
    public int get(int key) {
        ListNode curr = list[key%10000];
        while(curr.next!=null) {
            if(curr.next.key == key) {
                return curr.next.val;
            }
            curr = curr.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        ListNode curr = list[key%10000];
        while(curr.next!=null) {
            if(curr.next.key == key) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */