class Node:
    def __init__(self):
        self.children = {}
        self.is_end = False
class WordDictionary:

    def __init__(self):
        self.root = Node()

    def addWord(self, word: str) -> None:
        node = self.root
        for c in word:
            if c not in node.children:
                node.children[c] = Node()
            node = node.children[c]
        node.is_end = True

    def search(self, word: str) -> bool:
        def helper(idx, node):
            if idx==len(word):
                return node.is_end
            c = word[idx]
            if c==".":
                for child in node.children.values():
                    if helper(idx+1, child):
                        return True
            if c not in node.children:
                return False
            return helper(idx+1, node.children[c])
        return helper(0,self.root)
        



