class LRUCache {
    class Node {
        int key;
        int val;
        Node prev;
        Node next;
        public Node(int k, int v) {
            key = k;
            val = v;
        }
    }

    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node curr = head.next;
        while(curr != tail) {
            if(curr.key == key) {
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;
                head.next.prev = curr;
                curr.next = head.next;
                head.next = curr;
                curr.prev = head;
                return curr.val;
            }
            curr = curr.next;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node curr = head.next;
        while(curr != tail) {
            if(curr.key == key) {
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;
                head.next.prev = curr;
                curr.next = head.next;
                head.next = curr;
                curr.prev = head;
                curr.val = value;
                return;
            }
            curr = curr.next;
        }
        Node n = new Node(key, value);
        if(capacity==0) {
            tail.prev = tail.prev.prev;
            tail.prev.next = tail;
            capacity++;
        }
        head.next.prev = n;
        n.next = head.next;
        n.prev = head;
        head.next = n;
        capacity--;
    }
}
