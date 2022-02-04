t = int(input())

def get_bins(nums):
    bins = []
    max_len = 0
    for i in nums:
        bin = f"{i:b}"
        l = len(bin)
        bins.append(bin)
        max_len = l if l > max_len else max_len
    
    for b in range(len(bins)):
        bins[b] = bins[b].zfill(max_len)
    
    return bins, max_len

while t > 0:
    t -= 1
    n = int(input())
    nums = list(map(int, input().split()))

    bins, max_len = get_bins(nums)
    num = 0
    flag = False
    for i in range(max_len - 1, 0, -1):
        set_count = 0
        for b in bins:
            if b[i] == '1':
                set_count += 1
        if set_count % 2 == 1:
            add = 1 << (max_len - 1 - i)
            num += add
            nums = [j + add for j in nums]
            bins, _ = [f"{j:b}".zfill(max_len) for j in nums]
    
    set_count = 0
    for b in bins:
        if b[0] == '1':
            set_count += 1
    if set_count % 2 == 1:
        print(-1)
    else:
        print(num)





# t = int(input())

# while t > 0:
#     t -= 1
#     n = int(input())
#     nums = list(map(int, input().split()))
#     bins = [f"{i:b}".zfill(64) for i in nums]
#     num = 0
#     flag = False
#     for i in range(63, 0, -1):
#         set_count = 0
#         for b in bins:
#             if b[i] == '1':
#                 set_count += 1
#         if set_count % 2 == 1:
#             if i == 1:
#                 print(-1)
#                 flag = True
#                 break
#             add = 2 ** (63 - i)
#             num += add
#             nums = [j + add for j in nums]
#             bins = [f"{j:b}".zfill(64) for j in nums]
    
#     if not flag:
#         print(num)
