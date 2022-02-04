from collections import Counter
t = int(input())

while t > 0:
    t -= 1
    n = int(input())
    nums = list(map(int, input().split()))
    nums.sort(reverse=True)
    if n >= 2 and nums[0] == nums[1]:
        print(-1)
        continue

    count = Counter(nums)
    seq = []
    for i in count:
        if count[i] >= 3:
            print(-1)
            break
        elif count[i] == 2:
            seq.insert(0, i)
            seq.append(i)
        else:
            seq.append(i)
    
    if len(seq) != n:
        continue
    print(seq, sep=' ')

