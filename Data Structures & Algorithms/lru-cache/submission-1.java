class ListNode {
    int key;
    int val;
    ListNode next;
    ListNode prev;
    public ListNode(int k, int v) {
        key = k;
        val = v;
        next = null;
        prev = null;
    }
}
class LRUCache {
    int capacity;
    ListNode left;
    ListNode right;
    Map<Integer, ListNode> hm;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        left = new ListNode(0,0);
        right = new ListNode(0,0);
        hm = new HashMap<>();
        left.next = right;
        right.prev = left;
    }
    
    public int get(int key) {
        if(!hm.containsKey(key))
            return -1;
        ListNode node = hm.get(key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        insert(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        ListNode node = null;
        if(hm.containsKey(key)) {
            node = hm.get(key);
            node.val = value;
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        else {
            node = new ListNode(key, value);
            capacity--;
        }
        insert(node);
        hm.put(key, node);
        if(capacity<0) {
            remove();
            capacity++;
        }
    }
    public void insert(ListNode node) {
        right.prev.next = node;
        node.prev = right.prev;
        node.next = right;
        right.prev = node;
    }
    public void remove() {
        hm.remove(left.next.key);
        left.next = left.next.next;
        left.next.prev = left;
    }
}
