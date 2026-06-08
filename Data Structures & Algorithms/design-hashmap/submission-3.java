class MyHashMap {
    class List {
        int key;
        int val;
        List next;
        public List(int k, int v) {
            key = k;
            val = v;
            next = null;
        }
    }

    List[] list;

    public MyHashMap() {
        list = new List[10000];
        for(int i=0; i<10000; i++)
            list[i] = new List(0,0);
    }
    
    public void put(int key, int value) {
        int hash = key%10000;
        List tmp = list[hash];
        while(tmp.next!=null) {
            if(tmp.next.key==key) {
                tmp.next.val = value;
                return;
            }
            tmp = tmp.next;
        }
        tmp.next = new List(key, value);
    }
    
    public int get(int key) {
        int hash = key%10000;
        List tmp = list[hash];
        while(tmp.next!=null) {
            if(tmp.next.key==key) {
                return tmp.next.val;
            }
            tmp = tmp.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        int hash = key%10000;
        List tmp = list[hash];
        while(tmp.next!=null) {
            if(tmp.next.key==key) {
                tmp.next = tmp.next.next;
                return;
            }
            tmp = tmp.next;
        }
        return;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */