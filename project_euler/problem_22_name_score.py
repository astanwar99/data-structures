file = open('p022_names.txt')
txt = file.readline().split(",")
txt.sort()


def get_score(n):
    nums = [ord(c) - 64 for c in n.replace('"', '')]
    return sum(nums)


tsum = 0
for i, n in enumerate(txt):

    score = get_score(n)
    tsum += score * (i + 1)
print(tsum)
