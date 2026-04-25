class ListNode:
    def __init__(self, key: int, val: int):
        self.key = key
        self.val = val
        self.next = None
class MyHashMap:

    def __init__(self):
        self.root = [ListNode(0,0) for _ in range(10000)]

    def put(self, key: int, value: int) -> None:
        k = key % 10000
        curr = self.root[k]
        while curr.next:
            if curr.next.key == key:
                curr.next.val = value
                return
            curr = curr.next
        curr.next = ListNode(key, value)

    def get(self, key: int) -> int:
        k = key % 10000
        curr = self.root[k]
        while curr.next:
            if curr.next.key == key:
                return curr.next.val
            curr = curr.next
        return -1

    def remove(self, key: int) -> None:
        k = key % 10000
        curr = self.root[k]
        while curr.next and curr.next.key != key:
            curr = curr.next
        if curr.next:
            curr.next = curr.next.next


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)