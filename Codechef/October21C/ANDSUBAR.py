import math
 
def highestPowerof2(n):
 
    p = int(math.log(n, 2))
    return int(pow(2, p))

t = int(input())

while t > 0:
    n = int(input())
    a = highestPowerof2(n)
    b = highestPowerof2(a-1)

    l1 = 1 + n - a
    l2 = b - a
    print(n, a, b, l1, l2)
    t -= 1