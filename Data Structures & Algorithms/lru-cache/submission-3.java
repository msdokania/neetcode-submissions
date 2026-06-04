class LRUCache {
    class Node {
        int key;
        int val;
        Node next;
        Node prev;
        public Node(int k, int v) {
            key = k;
            val = v;
            next = null;
            prev = null;
        }
    }

    int cap;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        cap = capacity;
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node curr = head.next;
        int ans = 0;
        while(curr!=tail) {
            if(curr.key == key) {
                ans = curr.val;
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;
                head.next.prev = curr;
                curr.next = head.next;
                head.next = curr;
                curr.prev = head;
                return ans;
            }
            curr = curr.next;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node curr = head.next;
        int ans = 0;
        while(curr!=tail) {
            if(curr.key == key) {
                curr.val = value;
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;
                head.next.prev = curr;
                curr.next = head.next;
                head.next = curr;
                curr.prev = head;
                return;
            }
            curr = curr.next;
        }
        Node n = new Node(key, value);
        head.next.prev = n;
        n.next = head.next;
        head.next = n;
        n.prev = head;
        if(cap==0) {
            tail.prev = tail.prev.prev;
            tail.prev.next = tail;
            return;
        }
        cap--;
        return;
    }
}

