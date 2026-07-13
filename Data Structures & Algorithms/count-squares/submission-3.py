class CountSquares:

    def __init__(self):
        self.xtoy = defaultdict(list)
        self.points = defaultdict(int)

    def add(self, point: List[int]) -> None:
        x,y = point[0],point[1]
        self.points[(x,y)] += 1
        self.xtoy[x].append(y)

    def count(self, point: List[int]) -> int:
        x,y = point[0],point[1]
        if x not in self.xtoy:
            return 0
        ans = 0
        for ycoord in self.xtoy[x]:
            if ycoord==y:
                continue
            side = abs(ycoord-y)
            a = self.points[(x-side,y)]
            b = self.points[(x-side,ycoord)]
            ans += a*b
            a = self.points[(x+side,y)]
            b = self.points[(x+side,ycoord)]
            ans += a*b
        return ans
