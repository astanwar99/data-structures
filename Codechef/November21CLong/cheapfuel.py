t = int(input())

while t > 0:
    x, y, a, b, k = map(int, input().split())
    xe = x + a*k
    ye = y + a*k
    if xe > ye:
        print("PETROL")
    elif ye > xe:
        print("DIESEL")
    else:
        print("SAME PRICE")
    
    t -= 1