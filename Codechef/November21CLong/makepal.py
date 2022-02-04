t = int(input())

while t > 0:
    n = int(input())
    nums = list(map(int, input().split()))
    count = 0
    for i in nums:
        if i % 2 == 1:
            count += 1
    
    print(int(count / 2))
    t -= 1