def checkCons(x, y, tot):
    rem = tot % 2
    if rem > x:
        return False
    return True


t = int(input())

while t > 0:
    x, y = map(int, input().split())
    total = x + 2 * y
    if total % 2 == 0 and checkCons(x, y, total / 2):
        print("YES")
    else:
        print("NO")

    t -= 1