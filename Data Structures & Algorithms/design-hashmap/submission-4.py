class List:
    def __init__(self, k: int, v: int):
        self.key = k;
        self.val = v;
        self.next = None

class MyHashMap:

    def __init__(self):
        self.lst = [List(0,0) for _ in range(10000)];
        

    def put(self, key: int, value: int) -> None:
        hash = key % 10000
        x = self.lst[hash]
        while x.next is not None:
            if x.next.key==key:
                x.next.val = value
                return
            x = x.next
        x.next = List(key, value)

    def get(self, key: int) -> int:
        hash = key%10000
        x = self.lst[hash]
        while x.next is not None:
            if x.next.key==key:
                return x.next.val
            x = x.next
        return -1
        

    def remove(self, key: int) -> None:
        hash = key%10000
        x = self.lst[hash]
        while x.next is not None:
            if x.next.key==key:
                x.next = x.next.next
                return
            x = x.next
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)