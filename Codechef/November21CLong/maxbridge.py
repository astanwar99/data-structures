def completeGraph(n, m):
    for i in range(1, n + 1):
        for j in range(i + 1, n + 1):
            print(f"{i} {j}")

def chain(n):
    for i in range(1, n):
        print(f"{i} {i + 1}")

t = int(input())

while t > 0:
    t -= 1
    n, m = map(int, input().split())

    if m == n * (n - 1) / 2:
        completeGraph(n, m)
    elif m > n - 1:
        chain(n)
        rem = m - n + 1
        for i in range(3, n + 1):
            j = i - 2
            if rem == 0:
                break
            while j > 0 and rem > 0:
                print(f"{j} {i}")
                j -= 1
                rem -= 1
    else:
        chain(n)