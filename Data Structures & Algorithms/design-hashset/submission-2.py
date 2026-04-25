class ListNode:
    def __init__(self, key: int):
        self.key = key
        self.next = None
    
class MyHashSet:

    def __init__(self):
        self.root = [ListNode(0) for _ in range(10000)]

    def add(self, key: int) -> None:
        k = key % 10000
        curr = self.root[k]
        while curr.next:
            if curr.next.key == key:
                return
            curr = curr.next
        curr.next = ListNode(key)

    def remove(self, key: int) -> None:
        k = key % 10000
        curr = self.root[k]
        while curr.next and curr.next.key != key:
            curr = curr.next
        if curr.next:
            curr.next = curr.next.next

    def contains(self, key: int) -> bool:
        k = key % 10000
        curr = self.root[k]
        while curr.next:
            if curr.next.key == key:
                return True
            curr = curr.next
        return False
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)