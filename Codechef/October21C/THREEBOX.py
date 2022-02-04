t = int(input())

while t > 0:
    a, b, c, d = map(int, input().split())
    nums = [a, b, c]
    nums.sort(reverse=True)
    bags = 1
    temp = d
    
    for i in nums:
        if temp >= i:
            temp -= i
        else:
            temp = d - i
            bags += 1

    print(bags) 

    t -= 1
