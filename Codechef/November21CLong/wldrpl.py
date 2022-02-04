t = int(input())

class node:
    def __init__(self) -> None:
        self.min = None
        self.max = None
        self.valid = None
        self.op = None

class tree:
    def __init__(self, root) -> None:
        self.root = root
        self.children = []

    def parse_tree():
        

while t > 0:
    t -= 1
    valid = input()
    root = node()
    root.valid = valid
    root.op = '+'
    T = tree(root)

    n = int(input())
    for i in range(n):
        l, r = map(int, input().split())
    