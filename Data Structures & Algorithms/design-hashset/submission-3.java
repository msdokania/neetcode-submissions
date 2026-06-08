class MyHashSet {
    class List {
        int val;
        List next;
        public List(int v) {
            val = v;
            next = null;
        }
    }

    List[] list;

    public MyHashSet() {
        list = new List[10000];
        for(int i=0; i<10000; i++)
            list[i] = new List(0);
    }
    
    public void add(int key) {
        int hash = key%10000;
        List tmp = list[hash];
        while(tmp.next != null) {
            if(tmp.next.val==key) return;
            tmp = tmp.next;
        }
        tmp.next = new List(key);
    }
    
    public void remove(int key) {
        int hash = key%10000;
        List tmp = list[hash];
        while(tmp.next != null && tmp.next.val!=key) {
            tmp = tmp.next;
        }
        if(tmp.next != null)
            tmp.next = tmp.next.next;
    }
    
    public boolean contains(int key) {
        int hash = key%10000;
        List tmp = list[hash];
        while(tmp.next != null) {
            if(tmp.next.val==key) return true;
            tmp = tmp.next;
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