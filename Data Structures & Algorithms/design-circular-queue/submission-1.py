class Node:
    def __init__(self, v: int):
        self.val = v
        self.next = None
        self.prev = None

class MyCircularQueue:

    def __init__(self, k: int):
        self.k = k
        self.curr = 0
        self.head = Node(0)
        self.tail = Node(0)
        self.head.next = self.tail
        self.tail.prev = self.head
        self.tail.next = self.head
        self.head.prev = self.tail

    def enQueue(self, value: int) -> bool:
        if self.curr==self.k:
            return False
        self.curr += 1
        tmp = self.tail.prev
        tmp.next = Node(value)
        tmp.next.prev = tmp
        tmp.next.next = self.tail
        self.tail.prev = tmp.next
        return True

    def deQueue(self) -> bool:
        if self.curr==0:
            return False
        self.curr -= 1
        tmp = self.head.next.next
        self.head.next = tmp
        tmp.prev = self.head
        return True

    def Front(self) -> int:
        if self.curr==0:
            return -1
        return self.head.next.val

    def Rear(self) -> int:
        if self.curr==0:
            return -1
        return self.tail.prev.val

    def isEmpty(self) -> bool:
        return self.curr==0

    def isFull(self) -> bool:
        return self.curr==self.k


# Your MyCircularQueue object will be instantiated and called as such:
# obj = MyCircularQueue(k)
# param_1 = obj.enQueue(value)
# param_2 = obj.deQueue()
# param_3 = obj.Front()
# param_4 = obj.Rear()
# param_5 = obj.isEmpty()
# param_6 = obj.isFull()